package com.antiy.entity.vul;


/**
 * <p></p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulIntegralInfo {


    private static final long serialVersionUID = 1L;
    private Integer id;
    private String taskId;
    private String intergralEvent;
    private String vulNo;
    private String vulName;
    private String ip;
    private Integer vulPort;
    private Long commitDate;
    private Integer grade;
    private Integer commitUser;
    private Integer department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public String getIntergralEvent() {
        return intergralEvent;
    }

    public void setIntergralEvent(String intergralEvent) {
        this.intergralEvent = intergralEvent;
    }


    public String getVulNo() {
        return vulNo;
    }

    public void setVulNo(String vulNo) {
        this.vulNo = vulNo;
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


    public Integer getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(Integer commitUser) {
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
        return "VulIntegralInfo{" +
                "id=" + id +
                ", taskId='" + taskId + '\'' +
                ", intergralEvent='" + intergralEvent + '\'' +
                ", vulNo='" + vulNo + '\'' +
                ", vulName='" + vulName + '\'' +
                ", ip='" + ip + '\'' +
                ", vulPort=" + vulPort +
                ", commitDate=" + commitDate +
                ", grade=" + grade +
                ", commitUser=" + commitUser +
                ", department=" + department +
                '}';
    }
}