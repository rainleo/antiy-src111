package com.antiy.request.vul;

import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * VulIntegralInfoRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class VulIntegralInfoRequest implements ObjectValidator {

    @ApiModelProperty("")
    private String taskId;
    @ApiModelProperty("")
    private String intergralEvent;
    @ApiModelProperty("")
    private String vulNo;
    @ApiModelProperty("")
    private String vulName;
    @ApiModelProperty("")
    private String ip;
    @ApiModelProperty("")
    private Integer vulPort;
    @ApiModelProperty("")
    private Long commitDate;
    @ApiModelProperty("")
    private Integer grade;
    @ApiModelProperty("")
    private Integer commitUser;
    @ApiModelProperty("")
    private Integer department;


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
    public void validate() throws RequestParamValidateException {

    }

}