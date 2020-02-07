package com.antiy.service.user;

import com.antiy.base.PageResult;
import com.antiy.base.QueryCondition;
import com.antiy.common.base.IBaseService;
import com.antiy.entity.user.Menu;
import com.antiy.query.user.MenuQuery;
import com.antiy.request.BaseRequest;
import com.antiy.request.user.MenuRequest;
import com.antiy.response.user.MenuResponse;

import java.util.List;


/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface IMenuService extends IBaseService<Menu> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Integer saveMenu(MenuRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    String updateMenu(MenuRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<MenuResponse> queryListMenu(MenuQuery query) throws Exception;

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResult<MenuResponse> queryPageMenu(MenuQuery query) throws Exception;

    /**
     * 通过ID查询
     *
     * @param queryCondition
     * @return
     */
    MenuResponse queryMenuById(QueryCondition queryCondition) throws Exception;

    /**
     * 通过ID删除
     *
     * @param baseRequest
     * @return
     */
    String deleteMenuById(BaseRequest baseRequest) throws Exception;

}
