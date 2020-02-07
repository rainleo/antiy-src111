package com.antiy.service.user;

import com.antiy.base.PageResult;
import com.antiy.common.base.IBaseService;
import com.antiy.entity.user.Api;
import com.antiy.query.user.ApiQuery;

import java.util.List;


/**
 * <p>
 * 接口权限表 服务类
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
public interface IApiService extends IBaseService<Api> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    void saveApi(Api request);

    /**
     * 修改
     *
     * @param request
     * @return
     */
    void updateApi(Api request);

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<Api> queryListApi(ApiQuery query);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResult<Api> queryPageApi(ApiQuery query);

}
