package com.antiy.request.user;

import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * UserRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */
public class UserRequest implements ObjectValidator {

    /**
     * 业务编号
     */
    @NotNull(message = "用户id不能为空", groups = {Update.class} )
    private Long businessId;
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空", groups = {Add.class} )
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空", groups = {Add.class} )
    private String password;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 所属单位
     */
    @NotNull(message = "所属单位不能为空", groups = {Add.class, Update.class} )
    @ApiModelProperty("所属单位")
    private Integer department;
    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    private String idcard;
    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String phone;
    /**
     * 状态 1、可用 2、锁定 3、禁用
     */
    @ApiModelProperty("状态 1、可用 2、锁定 3、禁用")
    private Integer status;

    @NotNull(message = "角色类型不能为空", groups = {Add.class, Update.class} )
    @ApiModelProperty("角色类型 2、普通管理员 3、审核员 4、普通用户")
    private Integer roleType;

    public Long getBusinessId() {
        return businessId;
    }

    public void setBusinessId(Long businessId) {
        this.businessId = businessId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    @Override
    public void validate() throws RequestParamValidateException {

    }

}