package com.antiy.service.user.impl;

import com.antiy.base.PageResult;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.dao.user.ApiDao;
import com.antiy.entity.user.Api;
import com.antiy.query.user.ApiQuery;
import com.antiy.service.user.IApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 接口权限表 服务实现类
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
@Service
public class ApiServiceImpl extends BaseServiceImpl<Api> implements IApiService {

    @Resource
    private ApiDao apiDao;

    @Override
    public void saveApi(Api request) {
        apiDao.insert(request);
    }

    @Override
    public void updateApi(Api request) {
        apiDao.update(request);
    }

    @Override
    public List<Api> queryListApi(ApiQuery query) {
        List<Api> apiList = apiDao.findQuery(query);
        return apiList;
    }

    @Override
    public PageResult<Api> queryPageApi(ApiQuery query) {
        return new PageResult(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListApi(query));
    }
}
