package com.antiy.service.user.impl;

import com.antiy.base.BaseConverter;
import com.antiy.base.PageResult;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.consts.UserConstant;
import com.antiy.dao.user.RoleDao;
import com.antiy.dao.user.UserDao;
import com.antiy.entity.user.Department;
import com.antiy.entity.user.LoginUser;
import com.antiy.entity.user.User;
import com.antiy.exception.BusinessException;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.BussinessIdRequest;
import com.antiy.request.user.UserRequest;
import com.antiy.response.user.UserResponse;
import com.antiy.service.user.IUserService;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.SnowFlake;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    private Logger logger = LogUtils.get(this.getClass());

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private BaseConverter<UserRequest, User> requestConverter;
    @Resource
    private BaseConverter<User, UserResponse> responseConverter;
    @Autowired
    private LoginUserUtil loginUserUtil = new LoginUserUtil();

    @Override
    public Long saveUser(UserRequest request) throws Exception {
        LoginUser curUser = loginUserUtil.getUser();
        Integer roleId = roleDao.findRoleIdByUserId(curUser.getBusinessId());
        Integer requestRole = request.getRoleType();
        if (requestRole != null) {
            //超级管理员才能创建管理员
            if (UserConstant.ROLE_TYPE_ADMIN.equals(requestRole)
                    && !UserConstant.ROLE_TYPE_SUPERADMIN.equals(roleId)) {
                throw new BusinessException("您没有创建管理员的权限");
            }
            //超级管理员和管理员才能创建审核员
            if (UserConstant.ROLE_TYPE_SH.equals(requestRole)
                    && (!UserConstant.ROLE_TYPE_SUPERADMIN.equals(roleId)
                    || !UserConstant.ROLE_TYPE_ADMIN.equals(roleId))) {
                throw new BusinessException("您没有创建审核员的权限");
            }
        }
        User user = new User();
        int num = userDao.findCountByUsername(request.getUsername());
        logger.info("检查用户名是否重复");
        if (num > 0) {
            logger.info("用户名已存在");
            throw new BusinessException(UserConstant.USERNAME_EXIST);
        }
        BeanUtils.copyProperties(request, user);
        user.setBusinessId(new SnowFlake(0, 0).nextId());
        user.setStatus(UserConstant.USER_STATUS_NORMAL);
        user.setCreateUser(1111L);
        user.setGmtCreate(System.currentTimeMillis());
        userDao.insert(user);
        Map<String, Object> param = new HashMap<>(2);
        param.put("userId", user.getBusinessId());
        param.put("roleId", requestRole != null ? requestRole : 4);
        roleDao.saveUserRole(param);
        logger.info("创建用户成功");
        return user.getBusinessId();
    }

    @Override
    public String updateUser(UserRequest request) throws Exception {
        request.setUsername(null);
        request.setPassword(null);
        User user = requestConverter.convert(request, User.class);
        return userDao.update(user).toString();
    }

    @Override
    public void updatePassword(Long businessId, String newPassword) throws Exception {
        userDao.updateUserPassword(businessId, newPassword);
        logger.info("管理员更新用户密码成功");
    }

    @Override
    public void updatePassword(Long businessId, String oldPassword, String newPassword) throws Exception {
        logger.info("用户修改密码开始");
        User user = userDao.getById(businessId);
        if (!oldPassword.equals(user.getPassword())) {
            logger.info("用户修改密码旧密码错误");
            throw new BusinessException("原密码不正确");
        }
        userDao.updateUserPassword(businessId, newPassword);
        logger.info("用户修改密码成功");
    }

    @Override
    public List<UserResponse> queryListUser(UserQuery query) throws Exception {
        List<User> userList = userDao.findQuery(query);
        //TODO
        return responseConverter.convert(userList, UserResponse.class);
    }

    @Override
    public PageResult<UserResponse> queryPageUser(UserQuery query) throws Exception {
        return new PageResult<UserResponse>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListUser(query));
    }

    @Override
    public UserResponse queryUserByBussinessId(Long businessId) throws Exception {
        User user = userDao.getById(businessId);
        UserResponse userResponse = responseConverter
                .convert(user, UserResponse.class);
        return userResponse;
    }

    @Override
    public String deleteUserById(BussinessIdRequest baseRequest) throws Exception {
        return userDao.deleteById(baseRequest.getBusinessId()).toString();
    }

    @Override
    public List<Department> getDepartmentList() {
        return userDao.getDepartmentList();
    }
}
