package com.antiy.request.vul;


import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p>
 * TaskInfoRequest 请求对象
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class TaskInfoRequest implements ObjectValidator {

    @ApiModelProperty("任务名")
    @NotBlank(message = "任务名不能为空")
    private String taskName;
    /**
     * 1.排雷2.扫雷
     */
    @ApiModelProperty("1.排雷2.扫雷")
    @NotNull(message = "任务类型不能为空")
    private Integer taskType;
    @NotNull(message = "开始时间不能为空")
    @ApiModelProperty("开始时间")
    private Long startTime;
    @NotNull(message = "结束时间不能为空")
    @ApiModelProperty("结束时间")
    private Long endTime;

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
        return "TaskInfoRequest{" +
                "taskName='" + taskName + '\'' +
                ", taskType=" + taskType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public void validate() throws RequestParamValidateException {

    }

}