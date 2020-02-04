package com.antiy.request.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program kbms-parent
 * @description 启用禁用用户
 * @author wangqian
 * created on 2019-07-26
 * @version  1.0.0
 */
public class UserStatusRequest {

    @ApiModelProperty("业务主键")
    private String bh;

    @ApiModelProperty("状态")
    private Integer status;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
