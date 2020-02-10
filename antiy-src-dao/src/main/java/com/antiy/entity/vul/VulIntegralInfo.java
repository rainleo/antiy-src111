package com.antiy.entity.vul;

/**
 * <p></p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulIntegralInfo {

    private Integer id;
    private Integer taskId;
    private String  intergralEvent;
    private Integer vulId;
    private String  vulName;
    private String  ip;
    private Integer vulPort;
    private Long    commitDate;
    private Integer grade;
    private Long    commitUser;
    private Integer department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

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

    @Override
    public String toString() {
        return "VulIntegralInfo{" + "id=" + id + ", taskId=" + taskId + ", intergralEvent='" + intergralEvent + '\''
               + ", vulId='" + vulId + '\'' + ", vulName='" + vulName + '\'' + ", ip='" + ip + '\'' + ", vulPort="
               + vulPort + ", commitDate=" + commitDate + ", grade=" + grade + ", commitUser=" + commitUser
               + ", department=" + department + '}';
    }
}