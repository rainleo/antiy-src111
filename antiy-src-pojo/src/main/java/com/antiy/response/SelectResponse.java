package com.antiy.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 下拉选择框
 * @author zhangxin
 * @date 2019/11/13
 */
public class SelectResponse {

    @ApiModelProperty("名称")
    private String name;

    @ApiModelProperty("值")
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SelectResponse(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public SelectResponse() {
    }
}
