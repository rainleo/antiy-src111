package com.antiy.service.user;

import com.antiy.base.PageResult;
import com.antiy.common.base.IBaseService;
import com.antiy.entity.user.Menu;
import com.antiy.entity.user.User;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.UserRequest;
import com.antiy.response.user.UserResponse;

import java.util.List;


/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
public interface IUserService extends IBaseService<User> {

    /**
    * 保存用户
    * @param request 请求参数
    * @return void
    * @author wangqian
    * @date 2019/7/25
    */
    void saveUser(UserRequest request) throws Exception;

    /**
    * 更新用户
    * @param request 请求参数
    * @return void
    * @author wangqian
    * @date 2019/7/25
    */
    void updateUser(UserRequest request);

    /**
    * 根据业务主键查询用户详情
    * @param bh 业务主键
    * @return com.antiy.response.user.UserResponse
    * @author wangqian
    * @date 2019/7/26
    */
    UserResponse getUserByBh(String bh);


    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<User> queryListUser(UserQuery query);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResult<User> queryPageUser(UserQuery query);

    /**
    * 更新用户状态
    * @param bh 编号
    * @param  status 状态
    * @return void
    * @author wangqian
    * @date 2019/7/26
    */
    void updateUserStatus(String bh, Integer status);

    /**
    * 管理员更新用户密码
    * @param bh 业务主键
    * @param newPassword 新密码
    * @return void
    * @author wangqian
    * @date 2019/7/26
    */
    void updatePassword(String bh, String newPassword) throws Exception;

    /**
     * 用户自己修改密码
     * @param bh 业务主键
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return void
     * @author wangqian
     * @date 2019/7/26
     */
    void updatePassword(String bh, String oldPassword, String newPassword) throws Exception;

    /**
    * 查询菜单树
    * @param
    * @return com.antiy.entity.user.Menu
    * @author wangqian
    * @date 2019/7/26
    */
    Menu getMenuTree();
}
