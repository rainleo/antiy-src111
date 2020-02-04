package com.antiy.service.user.impl;

import com.antiy.base.PageResult;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.consts.UserConstant;
import com.antiy.dao.user.MenuDao;
import com.antiy.dao.user.UserDao;
import com.antiy.entity.user.Menu;
import com.antiy.entity.user.User;
import com.antiy.exception.BusinessException;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.UserRequest;
import com.antiy.response.user.UserResponse;
import com.antiy.service.user.IUserService;
import com.antiy.util.LoginTipHolder;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.UuidUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserDao userDao;

    @Resource
    private MenuDao menuDao;

    private static Menu tree = null;

    @Autowired
    private LoginUserUtil loginUserUtil = new LoginUserUtil();

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveUser(UserRequest request) throws Exception {
        int num = userDao.findByUsername(request.getUsername());
        logger.info("检查用户名是否重复");
        if (num > 0) {
            logger.info("用户名已存在");
            throw new BusinessException(UserConstant.USERNAME_EXIST);
        }
        User user = new User();
        String bh = UuidUtil.getUuid();
        user.setBh(bh);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setStatus(UserConstant.USER_STATUS_NORMAL);
        user.setUserType(UserConstant.USER_TYPE_SYSTEM);
        user.setCreateUser(loginUserUtil.getUser().getBh());
        user.setGmtCreate(System.currentTimeMillis());
        userDao.insert(user);
        List<String> menuBhs = request.getMenuBhs();
        Map<String, Object> param = new HashMap<>(2);
        param.put("bh", bh);
        param.put("menuBhs", menuBhs);
        userDao.saveUserMenu(param);
        logger.info("创建用户成功");
    }
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(UserRequest request) {
        logger.info("开始更新用户信息");
        User user = new User();
        user.setBh(request.getBh());
        user.setUsername(request.getUsername());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        userDao.update(user);
        List<String> menuBhs = request.getMenuBhs();
        if (CollectionUtils.isNotEmpty(menuBhs)) {
            List<String> oldMeansOfUser = userDao.findMenuBhsByUserBh(request.getBh());
            if(!CollectionUtils.isEqualCollection(oldMeansOfUser,request.getMenuBhs())){
                userDao.deleteUserMenu(request.getBh());
                Map<String, Object> param = new HashMap<>(2);
                param.put("bh", request.getBh());
                param.put("menuBhs", request.getMenuBhs());
                userDao.saveUserMenu(param);
                LoginTipHolder.putTip(request.getBh(),"您的账号权限被修改，请重新登录");
            }
        }
        logger.info("更新用户信息成功");
    }

    @Override
    public UserResponse getUserByBh(String bh) {
        User user = userDao.getById(bh);
        UserResponse response = new UserResponse();
        response.setBh(user.getBh());
        response.setEmail(user.getEmail());
        response.setGmtCreate(user.getGmtCreate());
        response.setLastLoginTime(user.getLastLoginTime());
        response.setName(user.getName());
        response.setUsername(user.getUsername());
        List<String> menuBhs = userDao.findMenuBhsByUserBh(bh);
        response.setMenuBhs(menuBhs);
        return response;
    }

    @Override
    public void updateUserStatus(String bh, Integer status) {
        logger.info("启用/禁用用户开始");
        User user = new User();
        user.setBh(bh);
        user.setStatus(status);
        if (UserConstant.USER_STATUS_FORBIDDEN.equals(status)) {
            LoginTipHolder.putTip(bh, "您的账号状态已被禁用/锁定，请联系管理员");
        } else if (UserConstant.USER_STATUS_NORMAL.equals(status)) {
            LoginTipHolder.removeTip(bh);
            user.setErrorCount(0);
        }
        userDao.update(user);
        logger.info("启用/禁用用户成功");
    }

    @Override
    public List<User> queryListUser(UserQuery query) {
        List<User> userList = userDao.findQuery(query);
        return userList;
    }

    @Override
    public PageResult<User> queryPageUser(UserQuery query) {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListUser(query));
    }

    @Override
    public void updatePassword(String bh, String newPassword) throws Exception {
        userDao.updateUserPassword(bh, newPassword);
        logger.info("管理员更新用户密码成功");
    }

    @Override
    public void updatePassword(String bh, String oldPassword, String newPassword) throws Exception {
        logger.info("用户修改密码开始");
        User user = userDao.getById(bh);
        if (!oldPassword.equals(user.getPassword())) {
            logger.info("用户修改密码旧密码错误");
            throw new BusinessException("原密码不正确");
        }
        userDao.updateUserPassword(bh, newPassword);
        logger.info("用户修改密码成功");
    }

    @Override
    public Menu getMenuTree() {
        if (tree != null) {
            return tree;
        }
        synchronized (this) {
            if (tree != null) {
                return tree;
            }
            List<Menu> menus = menuDao.getAll();
            Menu root = null;
            for (Menu menu : menus) {
                //根节点
                if ("0".equals(menu.getParentBh())) {
                    root = menu;
                    break;
                }
            }
            if (root == null) {
                logger.error("菜单初始数据异常，未发现根节点");
                throw new BusinessException("菜单初始数据异常，未发现根节点");
            }
            findChildren(root, menus);
            tree = root;
        }
        return tree;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    private Menu findChildren(Menu treeNode, List<Menu> treeNodes) {
        for (Menu menu : treeNodes) {
            if (treeNode.getBh().equals(menu.getParentBh())) {
                if (treeNode.getChilds() == null) {
                    treeNode.setChilds(new ArrayList<>());
                }
                
                treeNode.getChilds().add(findChildren(menu, treeNodes));
            }
        }
        return treeNode;
    }
}