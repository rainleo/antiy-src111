package com.antiy.entity.user;


/**
 * <p>用户</p>
 *
 * @author wangqian
 * @since 2019-07-25
 */

public class User {
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private static final long serialVersionUID = 1L;
    /**
     * 用户标识
     */
    private String bh;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 电子邮箱
     */
    private String email;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 1、系统用户 2、外部用户
     */
    private Integer userType;
    /**
     * 已输错次数
     */
    private Integer errorCount;
    /**
     * 锁定时间
     */
    private Long lockedTime;
    /**
     * 最后一次登陆时间
     */
    private Long lastLoginTime;
    /**
     * 密码最后修改时间
     */
    private Long lastModifiedPassword;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    private Long gmtCreate;


    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
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


    public Long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }


    public Long getLastModifiedPassword() {
        return lastModifiedPassword;
    }

    public void setLastModifiedPassword(Long lastModifiedPassword) {
        this.lastModifiedPassword = lastModifiedPassword;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Override
    public String toString() {
        return "User{" +
                ", bh=" + bh +
                ", username=" + username +
                ", password=" + password +
                ", name=" + name +
                ", email=" + email +
                ", status=" + status +
                ", userType=" + userType +
                ", errorCount=" + errorCount +
                ", lockedTime=" + lockedTime +
                ", lastLoginTime=" + lastLoginTime +
                ", lastModifiedPassword=" + lastModifiedPassword +
                ", createUser=" + createUser +
                ", gmtCreate=" + gmtCreate +
                "}";
    }
}