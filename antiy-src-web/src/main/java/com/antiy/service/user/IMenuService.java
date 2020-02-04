package com.antiy.service.user;

import com.antiy.base.PageResult;
import com.antiy.common.base.IBaseService;
import com.antiy.entity.user.Menu;
import com.antiy.query.user.MenuQuery;

import java.util.List;


/**
 * <p>
 * 功能权限 服务类
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
public interface IMenuService extends IBaseService<Menu> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    void saveMenu(Menu request);

    /**
     * 修改
     *
     * @param request
     * @return
     */
    void updateMenu(Menu request);

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<Menu> queryListMenu(MenuQuery query);

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResult<Menu> queryPageMenu(MenuQuery query);

}
