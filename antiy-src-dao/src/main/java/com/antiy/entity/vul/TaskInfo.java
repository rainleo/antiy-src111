package com.antiy.entity.vul;

/**
 * <p></p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class TaskInfo {

    private Integer id;
    private String  taskName;
    /**
     * 1.扫雷2.排雷
     */
    private Integer taskType;
    private String  taskNo;
    private Long    startTime;
    private Long    endTime;
    /**
     * 1.进行中2.已关闭
     */
    private Integer taskStatus;
    private Long    createUser;
    private Long    modifyUser;
    private Long    gmtCreate;
    private Long    gmtModify;
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(Long modifyUser) {
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
    public String toString() {
        return "TaskInfo{" + "id=" + id + ", taskName='" + taskName + '\'' + ", taskType=" + taskType + ", taskNo='"
               + taskNo + '\'' + ", startTime=" + startTime + ", endTime=" + endTime + ", taskStatus=" + taskStatus
               + ", createUser=" + createUser + ", modifyUser=" + modifyUser + ", gmtCreate=" + gmtCreate
               + ", gmtModify=" + gmtModify + ", status=" + status + '}';
    }
}