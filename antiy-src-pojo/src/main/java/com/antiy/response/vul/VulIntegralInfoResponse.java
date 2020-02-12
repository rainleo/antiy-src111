package com.antiy.response.vul;


/**
 * <p>
 * VulIntegralInfoResponse 响应对象
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulIntegralInfoResponse {
    private String  intergralEvent;
    private Integer vulId;
    private String  vulName;
    private String  ip;
    private Integer vulPort;
    private Long    commitDate;
    private Integer grade;
    private Long    commitUser;
    private Integer department;


    public String getIntergralEvent() {
        return intergralEvent;
    }

    public void setIntergralEvent(String intergralEvent) {
        this.intergralEvent = intergralEvent;
    }

    public Integer getVulId() {
        return vulId;
    }

    public void setVulId(Integer vulId) {
        this.vulId = vulId;
    }

    public String getVulName() {
        return vulName;
    }

    public void setVulName(String vulName) {
        this.vulName = vulName;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getVulPort() {
        return vulPort;
    }

    public void setVulPort(Integer vulPort) {
        this.vulPort = vulPort;
    }

    public Long getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Long commitDate) {
        this.commitDate = commitDate;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Long getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(Long commitUser) {
        this.commitUser = commitUser;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }
}