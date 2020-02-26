package com.antiy.service.user.impl;

import com.antiy.base.ActionResponse;
import com.antiy.base.RespBasicCode;
import com.antiy.common.utils.AesEncryptUtil;
import com.antiy.common.utils.LogUtils;
import com.antiy.consts.UserConstant;
import com.antiy.dao.user.MenuDao;
import com.antiy.dao.user.RoleDao;
import com.antiy.dao.user.UserDao;
import com.antiy.entity.user.LoginUser;
import com.antiy.entity.user.NullUser;
import com.antiy.entity.user.Role;
import com.antiy.entity.user.User;
import com.antiy.enums.user.UserStatus;
import com.antiy.response.user.UserBasicResponse;
import com.antiy.service.user.ILoginService;
import com.antiy.util.LoginTipHolder;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.MapUtil;
import com.antiy.util.TokenStoreUtil;
import com.antiy.util.jwt.JwtUtil;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 登录相关的服务
 *
 * @author zhouye
 * @date 2019-07-29
 */
@Service
public class LoginServiceImpl implements ILoginService {
    private Logger log = LogUtils.get(this.getClass());
    @Resource
    private UserDao userDao;
    @Resource
    private MenuDao menuDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private MapUtil<String, Object> mapUtil;
    @Resource
    private JwtUtil jwtUtil;
    @Resource
    private LoginUserUtil loginUserUtil;


    @Override
    public ActionResponse login(User user) {
        List<User> dbUsers = userDao.getUsersByUsername(user.getUsername());
        ActionResponse<Object> actionResponse = ActionResponse.success();
        User currentUser = new User();
        boolean isAuthentication = false;
        String encodePassword;

        if (dbUsers.size() > 1) {
            log.error("当前用户名重复", user.toString());
            actionResponse = ActionResponse.fail(RespBasicCode.ERROR, "当前库中存在脏数据，请联系管理员");
        }
        boolean passwordCompareResult = false;

        if (dbUsers.size() == 1) {
            currentUser = (User) dbUsers.get(0);
			/*Integer curUserStatus = currentUser.getStatus();
			//账号是否不可用
			if (UserStatus.forbidden.getCode().equals(curUserStatus) || isLockedAndUpdateStatus(currentUser)) {
				actionResponse = ActionResponse.fail(RespBasicCode.ACCOUNT_FORBIDDEN_OR_LOCKED, RespBasicCode.ACCOUNT_FORBIDDEN_OR_LOCKED.getResultDes());
				log.warn("用户{}账号被锁定/禁用，登录失败",currentUser.getUsername());
				return actionResponse;
			}*/
            try {
                encodePassword = AesEncryptUtil.aesEncrypt(user.getPassword());
                String currPassword = currentUser.getPassword();
                if (currPassword.equals(user.getPassword()) || currPassword.equals(encodePassword)) {
                    passwordCompareResult = true;
                }
                isAuthentication = passwordCompareResult;
            } catch (Exception e) {
                log.warn("登录失败,用户密码加密失败", e);
            }
        }
        //如果账户不存在，或者密码输入错误
        if (dbUsers.isEmpty() || (dbUsers.size() == 1 && !passwordCompareResult)) {
            log.warn("用户名或密码有误{}", user);
            //actionResponse = updatePasswordErrorCount(currentUser);
            actionResponse = ActionResponse.fail(RespBasicCode.ACCOUNT_LOGIN_ERROR, "用户名或密码错误");
        }
        if (isAuthentication) {
            String token;
            Long tokenKey = currentUser.getBusinessId();

            token = jwtUtil.getToken(tokenKey, currentUser.getUsername(), currentUser.getName());

            currentUser.setLastLoginTime(System.currentTimeMillis());
            currentUser.setErrorCount(0);
            userDao.update(currentUser);
            Map<String, Object> result = mapUtil.getMap("token", token);
            UserBasicResponse userResponse = new UserBasicResponse();
            Role role = roleDao.findRole(currentUser.getBusinessId());
            userResponse.setRoleId(role.getId());
            userResponse.setRoleName(role.getName());
            BeanUtils.copyProperties(currentUser, userResponse);
            userResponse.setBusinessId(currentUser.getBusinessId().toString());
            List<String> menus = menuDao.findMenusOfUser(currentUser.getBusinessId());
            userResponse.setMenus(menus);
            result.put("userInfo", userResponse);
            actionResponse.setBody(result);
            if (TokenStoreUtil.existToken(tokenKey)) {
                log.info("当前用户{}已登录，踢出之前登录客户端权限", currentUser.getUsername());
            }
            LoginUser userinfo = new LoginUser(currentUser.getBusinessId(),
                    userResponse.getUsername(), userResponse.getName(), userResponse.getDepartment());
            userinfo.setRoleId(role.getId());
            userinfo.setRoleName(role.getName());
            userinfo.setMenus(menus);
            if (TokenStoreUtil.existToken(currentUser.getBusinessId())) {
                LoginTipHolder.putTip(TokenStoreUtil.get(currentUser.getBusinessId()), "当前账号已有其他人使用，您被退出，请检查账号信息或联系管理员");
            }
            TokenStoreUtil.removeToken(currentUser.getBusinessId());
            TokenStoreUtil.put(token, System.currentTimeMillis() + UserConstant.EXPIRE, userinfo);
        }
        return actionResponse;
    }

    @Override
    public ActionResponse logout(String token) {
        TokenStoreUtil.removeToken(token);
        return ActionResponse.success();
    }

    private ActionResponse<Object> updatePasswordErrorCount(User user) {
        //如果用户名错误，无需更新错误次数
        if (user instanceof NullUser) {
            return ActionResponse.fail(RespBasicCode.ACCOUNT_LOGIN_ERROR, RespBasicCode.ACCOUNT_LOGIN_ERROR.getResultDes());
        }
        int historyErrorCount = user.getErrorCount() == null ? Integer.valueOf(0) : user.getErrorCount();
        int curChanceCount = 5 - historyErrorCount - 1;
        ActionResponse<Object> actionResponse = ActionResponse.fail(RespBasicCode.ACCOUNT_LOGIN_ERROR, "用户名或密码错误," + "还剩" + (5 - historyErrorCount - 1) + "次机会");
        if (curChanceCount <= 0) {
            user.setErrorCount(0);
            user.setStatus(UserStatus.locked.getCode());
            user.setLockedTime(System.currentTimeMillis());
            actionResponse = ActionResponse.fail(RespBasicCode.ACCOUNT_FORBIDDEN_OR_LOCKED, RespBasicCode.ACCOUNT_FORBIDDEN_OR_LOCKED.getResultDes());
        } else {
            user.setErrorCount(historyErrorCount + 1);
        }
        userDao.update(user);
        log.warn("更新用户{}的密码输错次数为" + user.getErrorCount(), user.getUsername());
        return actionResponse;
    }

    private boolean isLockedAndUpdateStatus(User user) {
        boolean result = false;
        if (UserStatus.locked.getCode().equals(user.getStatus())) {
            if (user.getLockedTime() == null) {
                log.warn("该用户锁定时间为null，数据库脏数据，请管理员及时处理");
                return false;
            }
            long unLockTime = user.getLockedTime() + 30 * 60 * 1000;
            if (unLockTime > System.currentTimeMillis()) {
                result = true;
                log.warn("该用户{}还处于锁定中。。。", user.getUsername());
            } else {
                user.setStatus(UserStatus.normal.getCode());
                user.setLockedTime(null);
                userDao.update(user);
                log.info("解锁用户{}", user.getUsername());
            }
        }
        return result;
    }

}
