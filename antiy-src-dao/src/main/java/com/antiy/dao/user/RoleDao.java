package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.Role;

import java.util.Map;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface RoleDao extends IBaseDao<Role> {

    Integer findRoleIdByUserId(Long businessId);

    void saveUserRole(Map<String, Object> param);

    Role findRole(Long userId);
}
