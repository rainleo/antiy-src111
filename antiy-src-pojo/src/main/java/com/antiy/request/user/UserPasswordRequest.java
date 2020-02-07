package com.antiy.request.user;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program kbms-parent
 * @description 用户密码更新请求
 * @author wangqian
 * created on 2019-07-26
 * @version  1.0.0
 */
public class UserPasswordRequest {

    @ApiModelProperty("业务主键")
    private Long businessId;

    @ApiModelProperty("旧密码")
    private String oldPassword;

    @ApiModelProperty("新密码")
    private String newPassword;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
