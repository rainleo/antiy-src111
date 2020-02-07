package com.antiy.service.user.impl;

import com.antiy.base.BaseConverter;
import com.antiy.base.PageResult;
import com.antiy.base.QueryCondition;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.dao.user.RoleDao;
import com.antiy.entity.user.Role;
import com.antiy.query.user.RoleQuery;
import com.antiy.request.user.BussinessIdRequest;
import com.antiy.request.user.RoleRequest;
import com.antiy.response.user.RoleResponse;
import com.antiy.service.user.IRoleService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements IRoleService {

    private Logger logger = LogUtils.get(this.getClass());

    @Resource
    private RoleDao roleDao;
    @Resource
    private BaseConverter<RoleRequest, Role> requestConverter;
    @Resource
    private BaseConverter<Role, RoleResponse> responseConverter;

    @Override
    public Integer saveRole(RoleRequest request) throws Exception {
        Role role = requestConverter.convert(request, Role.class);
        roleDao.insert(role);
        return role.getId();
    }

    @Override
    public String updateRole(RoleRequest request) throws Exception {
        Role role = requestConverter.convert(request, Role.class);
        return roleDao.update(role).toString();
    }

    @Override
    public List<RoleResponse> queryListRole(RoleQuery query) throws Exception {
        List<Role> roleList = roleDao.findQuery(query);
        //TODO
        return responseConverter.convert(roleList, RoleResponse.class);
    }

    @Override
    public PageResult<RoleResponse> queryPageRole(RoleQuery query) throws Exception {
        return new PageResult<RoleResponse>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListRole(query));
    }

    @Override
    public RoleResponse queryRoleById(QueryCondition queryCondition) throws Exception {
        RoleResponse roleResponse = responseConverter
                .convert(roleDao.getById(queryCondition.getPrimaryKey()), RoleResponse.class);
        return roleResponse;
    }

    @Override
    public String deleteRoleById(BussinessIdRequest baseRequest) throws Exception {
        return roleDao.deleteById(baseRequest.getBusinessId()).toString();
    }
}
