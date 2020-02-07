package com.antiy.service.user.impl;

import com.antiy.base.BaseConverter;
import com.antiy.base.PageResult;
import com.antiy.base.QueryCondition;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.dao.user.MenuDao;
import com.antiy.entity.user.Menu;
import com.antiy.query.user.MenuQuery;
import com.antiy.request.BaseRequest;
import com.antiy.request.user.MenuRequest;
import com.antiy.response.user.MenuResponse;
import com.antiy.service.user.IMenuService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    private Logger logger = LogUtils.get(this.getClass());

    @Resource
    private MenuDao menuDao;
    @Resource
    private BaseConverter<MenuRequest, Menu> requestConverter;
    @Resource
    private BaseConverter<Menu, MenuResponse> responseConverter;

    @Override
    public Integer saveMenu(MenuRequest request) throws Exception {
        Menu menu = requestConverter.convert(request, Menu.class);
        menuDao.insert(menu);
        return menu.getId();
    }

    @Override
    public String updateMenu(MenuRequest request) throws Exception {
        Menu menu = requestConverter.convert(request, Menu.class);
        return menuDao.update(menu).toString();
    }

    @Override
    public List<MenuResponse> queryListMenu(MenuQuery query) throws Exception {
        List<Menu> menuList = menuDao.findQuery(query);
        //TODO
        return responseConverter.convert(menuList, MenuResponse.class);
    }

    @Override
    public PageResult<MenuResponse> queryPageMenu(MenuQuery query) throws Exception {
        return new PageResult<MenuResponse>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListMenu(query));
    }

    @Override
    public MenuResponse queryMenuById(QueryCondition queryCondition) throws Exception {
        MenuResponse menuResponse = responseConverter
                .convert(menuDao.getById(queryCondition.getPrimaryKey()), MenuResponse.class);
        return menuResponse;
    }

    @Override
    public String deleteMenuById(BaseRequest baseRequest) throws Exception {
        return menuDao.deleteById(baseRequest.getId()).toString();
    }
}
