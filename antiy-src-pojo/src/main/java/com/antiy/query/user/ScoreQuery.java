package com.antiy.query.user;

import com.antiy.base.ObjectQuery;

/**
 * @program antiy-src-parent
 * @description 
 * @author wangqian
 * created on 2020-02-13
 * @version  1.0.0
 */
public class ScoreQuery extends ObjectQuery {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
