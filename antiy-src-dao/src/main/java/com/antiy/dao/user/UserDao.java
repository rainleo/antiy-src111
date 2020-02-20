package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.Department;
import com.antiy.entity.user.User;
import com.antiy.entity.vul.EventLevel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> 用户表 Mapper 接口 </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface UserDao extends IBaseDao<User> {

    int findCountByUsername(String username);

    List<User> getUsersByUsername(String username);

    void updateUserPassword(@Param("businessId") Long businessId, @Param("encodePwd") String encodePwd);

    List<Department> getDepartmentList();

    /**
     * 获取事件等级内容
     * @return
     */
    List<EventLevel> getEventLevel();

    List<User> getALlUser();

    /**
     * 获取用户角色
     * @param userId
     * @return
     */
    Integer getRoleByUserId(@Param("userId") long userId);

    List<String> getUserIdByRole(@Param("role") int role);

    List<User> getNormalUserList();
}
