package com.antiy.response.vul;

import com.antiy.enums.user.VulLevelEnum;
import com.antiy.enums.user.VulStatusEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p> VulInfoResponse 响应对象 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulInfoResponse {
    @ApiModelProperty("漏洞id")
    private Integer id;
    @ApiModelProperty("漏洞编号")
    private String  vulNo;
    @ApiModelProperty("漏洞名称")
    private String  vulName;
    @ApiModelProperty("漏洞ip")
    private String  ip;
    @ApiModelProperty("漏洞端口")
    private Integer vulPort;
    @ApiModelProperty("扫雷/排,1.扫雷,2.排雷")
    private Integer type;
    @ApiModelProperty("漏洞地址")
    private String  vulAddress;
    @ApiModelProperty("漏洞状态")
    private String  vulStatus;
    @ApiModelProperty("任务名称")
    private String  taskName;
    @ApiModelProperty("任务id")
    private Integer taskId;
    @ApiModelProperty("提交人")
    private Long    commitUser;
    @ApiModelProperty("提交人名称")
    private String  commitUserName;
    @ApiModelProperty("提交日期")
    private Long    commitDate;
    @ApiModelProperty("漏洞提交人所属部门")
    private Integer vulDepartment;
    @ApiModelProperty("地址归属单位")
    private Integer addressOwner;
    @ApiModelProperty("地址归属单位名称")
    private String  addressOwnerName;
    @ApiModelProperty("漏洞类型")
    private String  vulType;
    @ApiModelProperty("事件等级")
    private String  eventLevel;
    @ApiModelProperty("漏洞等级")
    private String  vulLevel;
    @ApiModelProperty("漏洞描述")
    private String  vulDesc;
    @ApiModelProperty("修复建议")
    private String  repairSuggest;
    @ApiModelProperty("部门")
    private Integer department;
    @ApiModelProperty("部门名")
    private String  departmentName;

    public String getAddressOwnerName() {
        return addressOwnerName;
    }

    public void setAddressOwnerName(String addressOwnerName) {
        this.addressOwnerName = addressOwnerName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getVulDepartment() {
        return vulDepartment;
    }

    public void setVulDepartment(Integer vulDepartment) {
        this.vulDepartment = vulDepartment;
    }

    public String getCommitUserName() {
        return commitUserName;
    }

    public void setCommitUserName(String commitUserName) {
        this.commitUserName = commitUserName;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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

    public Integer getAddressOwner() {
        return addressOwner;
    }

    public void setAddressOwner(Integer addressOwner) {
        this.addressOwner = addressOwner;
    }

    public String getVulType() {
        return vulType;
    }

    public void setVulType(String vulType) {
        this.vulType = vulType;
    }

    public String getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(String eventLevel) {
        this.eventLevel = eventLevel;
    }

    public String getVulLevel() {
        return vulLevel;
    }

    public void setVulLevel(String vulLevel) {
        this.vulLevel = VulLevelEnum.getMsg(Integer.parseInt(vulLevel));
    }

    public String getVulDesc() {
        return vulDesc;
    }

    public void setVulDesc(String vulDesc) {
        this.vulDesc = vulDesc;
    }

    public String getRepairSuggest() {
        return repairSuggest;
    }

    public void setRepairSuggest(String repairSuggest) {
        this.repairSuggest = repairSuggest;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getVulAddress() {
        return vulAddress;
    }

    public void setVulAddress(String vulAddress) {
        this.vulAddress = vulAddress;
    }

    public String getVulStatus() {
        return vulStatus;
    }

    public void setVulStatus(String vulStatus) {
        this.vulStatus = VulStatusEnum.getMsg(Integer.parseInt(vulStatus));
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Long getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Long commitDate) {
        this.commitDate = commitDate;
    }

    @Override
    public String toString() {
        return "VulInfoResponse{" + "id=" + id + ", vulNo='" + vulNo + '\'' + ", vulName='" + vulName + '\'' + ", ip='"
               + ip + '\'' + ", vulPort=" + vulPort + ", type=" + type + ", vulAddress='" + vulAddress + '\''
               + ", vulStatus='" + vulStatus + '\'' + ", taskName='" + taskName + '\'' + ", taskId=" + taskId
               + ", commitUser=" + commitUser + ", commitUserName='" + commitUserName + '\'' + ", commitDate="
               + commitDate + ", vulDepartment=" + vulDepartment + ", addressOwner=" + addressOwner
               + ", addressOwnerName='" + addressOwnerName + '\'' + ", vulType='" + vulType + '\'' + ", eventLevel='"
               + eventLevel + '\'' + ", vulLevel='" + vulLevel + '\'' + ", vulDesc='" + vulDesc + '\''
               + ", repairSuggest='" + repairSuggest + '\'' + ", department=" + department + ", departmentName='"
               + departmentName + '\'' + '}';
    }
}