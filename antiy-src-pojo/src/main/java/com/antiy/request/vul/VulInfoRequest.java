package com.antiy.request.vul;

import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * <p> VulInfoRequest 请求对象 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulInfoRequest implements ObjectValidator {

    @ApiModelProperty("漏洞id")
    private String  id;
    @ApiModelProperty("漏洞名称")
    private String  vulName;
    /**
     * 1.扫雷,2.排雷
     */
    @ApiModelProperty("1.扫雷,2.排雷")
    private Integer type;
    @ApiModelProperty("IP地址")
    @Pattern(regexp = "(([0,1]?\\d?\\d|2[0-4]\\d|25[0-5])\\.){3}([0,1]?\\d?\\d|2[0-4]\\d|25[0-5])", message = "IP格式错误")
    private String  ip;
    @ApiModelProperty("漏洞端口")
    private Integer vulPort;
    @ApiModelProperty("漏洞地址")
    private String  vulAddress;
    @ApiModelProperty("漏洞提交人所属部门")
    private Integer vulDepartment;
    @ApiModelProperty("地址归属单位")
    private Integer addressOwner;
    /**
     * 1.Web应用漏洞2.主机系统漏洞3.移动APP漏洞4.弱口令类漏洞
     */
    @ApiModelProperty("1.Web应用漏洞2.主机系统漏洞3.移动APP漏洞4.弱口令类漏洞")
    private Integer vulType;
    /**
     * 1高危漏洞，2中危漏洞3.低危漏洞
     */
    @ApiModelProperty("1高危漏洞，2中危漏洞3.低危漏洞")
    private Integer vulLevel;
    /**
     * A,B,C,D拼接
     */
    @ApiModelProperty("A,B,C,D拼接")
    private String  eventLevel;
    @ApiModelProperty("漏洞描述")
    private String  vulDesc;
    @ApiModelProperty("修复说明/修复建议")
    private String  repairSuggest;
    @ApiModelProperty("证明材料名称")
    private String  vulMaterialName;
    @ApiModelProperty("证明材料url")
    private String  vulMaterialUrl;
    /**
     * 1待审核2通过3未通过
     */
    @ApiModelProperty("1待审核2通过3未通过")
    private Integer vulStatus;
    @ApiModelProperty("任务id")
    private Integer taskId;
    /**
     * 1.普通系统2.重要或设计用户敏感信息系统
     */
    @ApiModelProperty("1.普通系统2.重要或设计用户敏感信息系统")
    private Integer systemType;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVulName() {
        return vulName;
    }

    public Integer getVulDepartment() {
        return vulDepartment;
    }

    public void setVulDepartment(Integer vulDepartment) {
        this.vulDepartment = vulDepartment;
    }

    public void setVulName(String vulName) {
        this.vulName = vulName;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    public Integer getAddressOwner() {
        return addressOwner;
    }

    public void setAddressOwner(Integer addressOwner) {
        this.addressOwner = addressOwner;
    }

    public Integer getVulLevel() {
        return vulLevel;
    }

    public void setVulLevel(Integer vulLevel) {
        this.vulLevel = vulLevel;
    }

    public String getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(String eventLevel) {
        this.eventLevel = eventLevel;
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

    public String getVulMaterialName() {
        return vulMaterialName;
    }

    public void setVulMaterialName(String vulMaterialName) {
        this.vulMaterialName = vulMaterialName;
    }

    public String getVulMaterialUrl() {
        return vulMaterialUrl;
    }

    public void setVulMaterialUrl(String vulMaterialUrl) {
        this.vulMaterialUrl = vulMaterialUrl;
    }

    public Integer getVulStatus() {
        return vulStatus;
    }

    public void setVulStatus(Integer vulStatus) {
        this.vulStatus = vulStatus;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
    }

    public Integer getVulType() {
        return vulType;
    }

    public void setVulType(Integer vulType) {
        this.vulType = vulType;
    }

    @Override
    public void validate() throws RequestParamValidateException {

    }

}