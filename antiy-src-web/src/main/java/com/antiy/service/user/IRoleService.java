package com.antiy.service.user;

import com.antiy.base.PageResult;
import com.antiy.base.QueryCondition;
import com.antiy.common.base.IBaseService;
import com.antiy.entity.user.Role;
import com.antiy.query.user.RoleQuery;
import com.antiy.request.user.BussinessIdRequest;
import com.antiy.request.user.RoleRequest;
import com.antiy.response.user.RoleResponse;

import java.util.List;


/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface IRoleService extends IBaseService<Role> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveRole(RoleRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    String updateRole(RoleRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<RoleResponse> queryListRole(RoleQuery query) throws Exception;

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResult<RoleResponse> queryPageRole(RoleQuery query) throws Exception;

    /**
     * 通过ID查询
     *
     * @param queryCondition
     * @return
     */
    RoleResponse queryRoleById(QueryCondition queryCondition) throws Exception;

    /**
     * 通过ID删除
     *
     * @param baseRequest
     * @return
     */
    String deleteRoleById(BussinessIdRequest baseRequest) throws Exception;

}
