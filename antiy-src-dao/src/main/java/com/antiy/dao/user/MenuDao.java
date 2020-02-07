package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface MenuDao extends IBaseDao<Menu> {

    List<String> findMenusOfUser(Long businessId);
}
