package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
public interface UserDao extends IBaseDao<User> {
    /**
     * 通过用户名或姓名查询用户数
     *
     * @param username 用户名
     * @param name     姓名
     * @return int
     * @author wangqian
     * @date 2019/7/25
     */
    int findByUsername(String username);

    /**
     * 保存用户和功能的关系
     *
     * @param param 用户编号和功能编号数组
     * @return void
     * @author wangqian
     * @date 2019/7/25
     */
    void saveUserMenu(Map<String, Object> param);

    /**
     * 删除用户和菜单的关系
     *
     * @param bh 编号
     * @return void
     * @author wangqian
     * @date 2019/7/25
     */
    void deleteUserMenu(String bh);

    /**
     * 更新用户状态
     *
     * @param bh     编号
     * @param status 状态
     * @return void
     * @author wangqian
     * @date 2019/7/26
     */
    void updateUserStatus(@Param("bh") String bh, @Param("status") Integer status);

    /**
     * 更新用户密码
     *
     * @param bh        业务主键
     * @param encodePwd 新密码
     * @return void
     * @author wangqian
     * @date 2019/7/26
     */
    void updateUserPassword(@Param("bh") String bh, @Param("encodePwd") String encodePwd);

    /**
     * 通过用户名获取用户信息
     * @param username
     * @return
     */
    List<User> getUserByUsername(String username);

    /**
    * 根据用户编号查询用户关联的功能菜单编号
    * @param bh 用户编号
    * @return java.util.List<java.lang.String>
    * @author wangqian
    * @date 2019/7/29
    */
    List<String> findMenuBhsByUserBh(String bh);

}
