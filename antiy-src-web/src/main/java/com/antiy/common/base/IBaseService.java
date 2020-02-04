package com.antiy.common.base;

import com.antiy.base.ObjectQuery;
import com.antiy.base.PageResult;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 类名称：IBaseService 类描述：Service基类（声明CRUD常用接口方法） 创建人： 创建时间：2016年11月8日下午5:40:20 修改人： 修改时间： 修改备注： 备注：所有service层接口都必须继承此类
 */
public interface IBaseService<T> {
    // 保存
    Integer save(T entity);

    // 修改
    Integer update(T entity);

    // 删除
    Integer deleteById(Serializable id);

    // 查询（ID）
    T getById(Serializable id);

    // 查询（where）
    List<T> getByWhere(HashMap<String, Object> params);

    // 查询（All）
    List<T> getAll();

    // 查询(分页 查询)
    PageResult<T> findPage(ObjectQuery queryObject);

    // 查询总条数
    Integer findCount(ObjectQuery objectQuery);
}
