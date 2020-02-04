package com.antiy.base;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author chenhuasheng
 * @describe
 * @date 2019/7/29 15:20
 */
public class QueryBusinessCondition extends ObjectQuery{
    /**
     * 业务主键id
     */
    @ApiModelProperty("业务主键id")
    private Long businessId;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

}
