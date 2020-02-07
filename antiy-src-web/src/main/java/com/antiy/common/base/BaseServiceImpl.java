package com.antiy.common.base;

import com.antiy.base.IBaseDao;
import com.antiy.base.ObjectQuery;
import com.antiy.base.PageResult;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 
 * 类名称：BaseServiceImpl 类描述：服务实现基类（实现了CRUD基本方法） 创建人： 创建时间：2016年11月8日下午6:04:58 修改人： 修改时间： 修改备注：
 * 说明：所有service实现都必须继承此类，若觉得不满足需求，@Override即可
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private IBaseDao<T> baseDao;

    /**
     * 
     * 方法名：save
     * @return
     * @param entity 返回类型：void 说明：保存 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
     */
    @Override
    public Integer save(T entity) {
        return baseDao.insert(entity);
    }

    /**
     * 
     * 方法名：update
     * @return
     * @param entity 返回类型：void 说明：修改 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
     */
    @Override
    public Integer update(T entity) {
        return baseDao.update(entity);
    }

    /**
     * 
     * 方法名：deleteById
     * @return
     * @param id 返回类型：void 说明：删除 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
     */
    @Override
    public Integer deleteById(Serializable id) {
        return baseDao.deleteById(id);
    }

    /**
     * 
     * 方法名：getById
     * @return
     * @param id 返回类型：T 说明：查询（ID） 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
     */
    @Override
    public T getById(Serializable id) {
        return baseDao.getById(id);
    }

    /**
     * 
     * 方法名：getByWhere
     * @return
     * @param params 返回类型：List<T> 说明：查询（Where） 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
     */
    @Override
    public List<T> getByWhere(HashMap<String, Object> params) {
        return baseDao.getByWhere(params);
    }

    /**
     * 
     * 方法名：getAll
     * @return 返回类型：List<T> 说明：查询（ALL） 创建人： 创建日期：2016年11月8日下午6:07:48 修改人： 修改日期：
     */
    @Override
    public List<T> getAll() {
        return baseDao.getAll();
    }

    /**
     * 
     * 方法名：getPageList
     * @param queryObject 查询对象
     * @return 返回类型：PageSupport<T> 说明：分页查询\一般查询（当queryObject为null,则作页面查询，就是一般结果集） 创建人： 创建日期：2016-5-24上午10:48:53 修改人：
     *         修改日期：
     */
    @Override
    public final PageResult<T> findPage(ObjectQuery queryObject) {
        PageResult<T> pageResult = new PageResult<T>();
        pageResult.setPageSize(queryObject.getPageSize());
        Integer totalPage = 0;
        // 1)分页查询
        if (queryObject != null) {
            Integer totalRecord = this.findCount(queryObject);
            if (totalRecord == null || totalRecord.intValue() <= 0) {
                pageResult.setItems(new ArrayList<T>());
                return pageResult;
            }
            pageResult.setTotalRecords(totalRecord);
            int total = totalRecord % queryObject.getPageSize();
            if (total == 0) {
                totalPage = totalRecord / queryObject.getPageSize();
            } else {
                totalPage = totalRecord / queryObject.getPageSize() + 1;
            }
        }
        if (queryObject.getCurrentPage() > totalPage) {
            queryObject.setCurrentPage(totalPage);
        }
        // 2)一般查询（没有分页）
        List<T> resultList = this.findQuery(queryObject);
        pageResult.setCurrentPage(queryObject.getCurrentPage());
        pageResult.setItems(resultList);
        return pageResult;
    }

    /**
     * 
     * 方法名：findQuery
     * @param objectQuery
     * @return
     * @throws Exception 返回类型：List<T> 说明：查询结果集 （分页查询基本实现，若自定义，@Override即可） 创建人: 创建日期：2016-7-13下午3:01:35 修改人： 修改日期：
     */
    public List<T> findQuery(ObjectQuery objectQuery) {
        return baseDao.findQuery(objectQuery);
    };

    /**
     * 
     * 方法名：findCount
     * @param objectQuery
     * @return
     * @throws Exception 返回类型：Integer 说明：查询总条数 （分页查询基本实现，若自定义，@Override即可） 创建人： 创建日期：2016-7-13下午3:02:31 修改人： 修改日期：
     */
    @Override
    public Integer findCount(ObjectQuery objectQuery) {
        return baseDao.findCount(objectQuery);
    }

}
