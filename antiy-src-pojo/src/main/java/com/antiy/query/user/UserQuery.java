package com.antiy.query.user;

import com.antiy.base.ObjectQuery;

/**
 * <p>
 * User 查询条件
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class UserQuery extends ObjectQuery {
    private Boolean isAdmin;

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}