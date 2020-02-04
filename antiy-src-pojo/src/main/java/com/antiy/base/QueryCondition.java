package com.antiy.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 统一的查询条件
 * @Author: zhangbing
 * @Date: 2018/10/30 13:58
 */
public class QueryCondition {

    /**
     * 服务请求Id,可用作日志记录
     */
    @ApiModelProperty(value = "服务请求Id")
    private String primaryKey;

    public String getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }
}
