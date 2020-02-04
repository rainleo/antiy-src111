package com.antiy.service.user.impl;

import com.antiy.base.PageResult;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.dao.user.MenuDao;
import com.antiy.entity.user.Menu;
import com.antiy.query.user.MenuQuery;
import com.antiy.service.user.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * <p>
 * 功能权限 服务实现类
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
@Service
public class MenuServiceImpl extends BaseServiceImpl<Menu> implements IMenuService {

    @Resource
    private MenuDao menuDao;

    @Override
    public void saveMenu(Menu request) {
        menuDao.insert(request);
    }

    @Override
    public void updateMenu(Menu request) {
        menuDao.update(request);
    }

    @Override
    public List<Menu> queryListMenu(MenuQuery query) {
        List<Menu> menuList = menuDao.findQuery(query);
        return menuList;
    }

    @Override
    public PageResult<Menu> queryPageMenu(MenuQuery query) {
        return new PageResult<>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListMenu(query));
    }
}
