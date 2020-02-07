package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.Department;
import com.antiy.entity.user.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface UserDao extends IBaseDao<User> {

    int findCountByUsername(String username);

    List<User> getUsersByUsername(String username);

    void updateUserPassword(@Param("businessId")Long businessId, @Param("encodePwd")String encodePwd);

    List<Department> getDepartmentList();
}
