package com.antiy.entity.user;


/**
 * <p>用户表</p>
 *
 * @author wq
 * @since 2020-02-05
 */

public class User {


private static final long serialVersionUID = 1L;
    private Integer id;

    /**
     * 业务编号
     */
    private Long businessId;
    /**
    *  用户名
    */
    private String username;
    /**
    *  密码
    */
    private String password;
    /**
    *  姓名
    */
    private String name;
    /**
    *  所属单位
    */
    private Integer department;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
    *  身份证号
    */
    private String idcard;
    /**
    *  联系电话
    */
    private String phone;
    /**
    *  状态 1、可用 2、锁定 3、禁用
    */
    private Integer status;

    private Integer errorCount;

    private Long lockedTime;

    private Long gmtCreate;
    private Long createUser;
    private Long gmtModified;
    private Long modifiedUser;
    private Long lastLoginTime;
    private String roleName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
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

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Long getLockedTime() {
        return lockedTime;
    }

    public void setLockedTime(Long lockedTime) {
        this.lockedTime = lockedTime;
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

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(Long modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
            return "User{" +
                        ", username=" + username +
                        ", password=" + password +
                        ", name=" + name +
                        ", department=" + department +
                        ", idcard=" + idcard +
                        ", phone=" + phone +
                        ", status=" + status +
            "}";
    }
}