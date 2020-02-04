package com.antiy.dao.user;

import com.antiy.base.IBaseDao;
import com.antiy.entity.user.Menu;

import java.util.List;

/**
 * <p>
 * 功能权限 Mapper 接口
 * </p>
 *
 * @author wangqian
 * @since 2019-07-25
 */
public interface MenuDao extends IBaseDao<Menu> {

   /**
   * @param bh 用户编号
   * @return java.util.List<java.lang.String>
   * @author wangqian
   * @date 2019/7/31
   */
    List<String> findMenusOfUser(String bh);
}
