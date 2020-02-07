package com.antiy.entity.vul;


/**
 * <p></p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulInfo {


    private Integer id;
    private String vulNo;
    private String vulName;
    /**
     * 1.扫雷,2.排雷
     */
    private Integer type;
    private String ip;
    private Integer vulPort;
    private String vulAddress;
    private Integer addressOwner;
    /**
     * 1.Web应用漏洞2.主机系统漏洞3.移动APP漏洞4.弱口令类漏洞
     */
    private String vulType;
    /**
     * 1高危漏洞，2中危漏洞3.低危漏洞
     */
    private Integer vulLevel;
    /**
     * A,B,C,D拼接
     */
    private String eventLevel;
    private String vulDesc;
    private String repairSuggest;
    private String vulMaterialName;
    private String vulMaterialUrl;
    /**
     * 1待审核2通过3未通过
     */
    private Integer vulStatus;
    private String taskId;
    /**
     * 1.普通系统2.重要或设计用户敏感信息系统
     */
    private Integer systemType;
    private Long createUser;
    private Long modifyUser;
    private Long gmtCreate;
    private Long gmtModify;
    /**
     * 0删除1正常
     */
    private Integer status;

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


    public String getVulType() {
        return vulType;
    }

    public void setVulType(String vulType) {
        this.vulType = vulType;
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


    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public Integer getSystemType() {
        return systemType;
    }

    public void setSystemType(Integer systemType) {
        this.systemType = systemType;
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
        return "VulInfo{" +
                "id=" + id +
                ", vulNo='" + vulNo + '\'' +
                ", vulName='" + vulName + '\'' +
                ", type=" + type +
                ", ip='" + ip + '\'' +
                ", vulPort=" + vulPort +
                ", vulAddress='" + vulAddress + '\'' +
                ", addressOwner=" + addressOwner +
                ", vulType='" + vulType + '\'' +
                ", vulLevel=" + vulLevel +
                ", eventLevel='" + eventLevel + '\'' +
                ", vulDesc='" + vulDesc + '\'' +
                ", repairSuggest='" + repairSuggest + '\'' +
                ", vulMaterialName='" + vulMaterialName + '\'' +
                ", vulMaterialUrl='" + vulMaterialUrl + '\'' +
                ", vulStatus=" + vulStatus +
                ", taskId='" + taskId + '\'' +
                ", systemType=" + systemType +
                ", createUser=" + createUser +
                ", modifyUser=" + modifyUser +
                ", gmtCreate=" + gmtCreate +
                ", gmtModify=" + gmtModify +
                ", status=" + status +
                '}';
    }
}