package com.antiy.response.user;

/**
 * <p>
 * UserResponse 响应对象
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class UserResponse {


    /**
     * 业务编号
     */
    private Long businessId;
    /**
     * 用户名
     */
    private String username;

    /**
     * 姓名
     */
    private String name;
    /**
     * 所属单位
     */
    private Integer department;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 状态 1、可用 2、锁定 3、禁用
     */
    private Integer status;

    private Long gmtCreate;
    private Long createUser;

    private Long lastLoginTime;


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

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}