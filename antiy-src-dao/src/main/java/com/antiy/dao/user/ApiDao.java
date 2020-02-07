package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.Api;

import java.util.List;

/**
 * <p>
 * 接口权限表 Mapper 接口
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
public interface ApiDao extends IBaseDao<Api> {
    /**
     * 根据用户bh获取用户拥有的功能权限对应的api
     * @param bh
     * @return
     */
    List<Api> findApiByUser(String bh);

}
