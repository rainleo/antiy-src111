package com.antiy.request.user;

import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * UserRequest 请求对象
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class UserRequest implements ObjectValidator {

    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 姓名
     */
    @ApiModelProperty("姓名")
    private String name;
    /**
     * 所属单位
     */
    @ApiModelProperty("所属单位")
    private String department;
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

    @ApiModelProperty("角色类型 2、普通管理员 3、审核员 4、普通用户")
    private Integer roleType;

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


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
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