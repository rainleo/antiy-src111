package com.antiy.request.vul;


import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * TaskInfoRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class TaskInfoRequest implements ObjectValidator {

    @ApiModelProperty("")
    private String taskName;
    /**
     * 1.排雷2.扫雷
     */
    @ApiModelProperty("1.排雷2.扫雷")
    private Integer taskType;
    @ApiModelProperty("")
    private String taskNo;
    @ApiModelProperty("")
    private Long startTime;
    @ApiModelProperty("")
    private Long endTime;
    /**
     * 1.进行中2.已关闭
     */
    @ApiModelProperty("1.进行中2.已关闭")
    private Integer taskStatus;
    @ApiModelProperty("")
    private Integer createUser;
    @ApiModelProperty("")
    private Integer modifyUser;
    @ApiModelProperty("")
    private Long gmtCreate;
    @ApiModelProperty("")
    private Long gmtModify;
    @ApiModelProperty("")
    private Integer status;


    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }


    public String getTaskNo() {
        return taskNo;
    }

    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo;
    }


    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }


    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }


    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }


    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }


    public Integer getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Integer modifyUser) {
        this.modifyUser = modifyUser;
    }


    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }


    public Long getGmtModify() {
        return gmtModify;
    }

    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    @Override
    public void validate() throws RequestParamValidateException {

    }

}