package com.antiy.response.vul;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p> TaskInfoResponse 响应对象 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

@ApiModel
public class TaskInfoResponse {
    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("任务名称")
    private String  taskName;
    @ApiModelProperty("任务类型")
    private Integer taskType;
    @ApiModelProperty("任务编号")
    private String  taskNo;
    @ApiModelProperty("开始时间")
    private Long    startTime;
    @ApiModelProperty("结束时间")
    private Long    endTime;

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

    @Override
    public String toString() {
        return "TaskInfoResponse{" + "id=" + id + ", taskName='" + taskName + '\'' + ", taskType=" + taskType
               + ", taskNo='" + taskNo + '\'' + ", startTime=" + startTime + ", endTime=" + endTime + '}';
    }
}