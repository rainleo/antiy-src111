package com.antiy.query.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program kbms-parent
 * @description 业务主键查询器
 * @author wangqian
 * created on 2019-07-25
 * @version  1.0.0
 */
public class BusinessIdQuery {

    @ApiModelProperty("业务主键")
    private Long bussinessId;

    public Long getBussinessId() {
        return bussinessId;
    }

    public void setBussinessId(Long bussinessId) {
        this.bussinessId = bussinessId;
    }
}
