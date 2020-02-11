package com.antiy.query.vul;

import com.antiy.base.ObjectQuery;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p> VulInfo 查询条件 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulInfoQuery extends ObjectQuery {

    @ApiModelProperty("漏洞编号")
    private String  vulNo;
    @ApiModelProperty("漏洞名称")
    private String  vulName;
    /**
     * 1.扫雷,2.排雷
     */
    @ApiModelProperty("1.扫雷,2.排雷")
    private Integer type;
    @ApiModelProperty("任务名称")
    private String  taskName;
    @ApiModelProperty("漏洞地址")
    private String  vulAddress;
    /**
     * 1高危漏洞，2中危漏洞3.低危漏洞
     */
    @ApiModelProperty("1高危漏洞，2中危漏洞3.低危漏洞")
    private Integer vulLevel;
    /**
     * 1待审核2通过3未通过
     */
    @ApiModelProperty("漏洞状态：1待审核2通过3未通过")
    private Integer vulStatus;
    @ApiModelProperty("漏洞所属部门")
    private Integer addressOwner;
    @ApiModelProperty("提交人")
    private Integer commitUser;
    @ApiModelProperty("提交人所属部门")
    private Integer commitDept;

    public Integer getAddressOwner() {
        return addressOwner;
    }

    public void setAddressOwner(Integer addressOwner) {
        this.addressOwner = addressOwner;
    }

    public Integer getCommitUser() {
        return commitUser;
    }

    public void setCommitUser(Integer commitUser) {
        this.commitUser = commitUser;
    }

    public Integer getCommitDept() {
        return commitDept;
    }

    public void setCommitDept(Integer commitDept) {
        this.commitDept = commitDept;
    }

    public Integer getVulStatus() {
        return vulStatus;
    }

    public void setVulStatus(Integer vulStatus) {
        this.vulStatus = vulStatus;
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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getVulAddress() {
        return vulAddress;
    }

    public void setVulAddress(String vulAddress) {
        this.vulAddress = vulAddress;
    }

    public Integer getVulLevel() {
        return vulLevel;
    }

    public void setVulLevel(Integer vulLevel) {
        this.vulLevel = vulLevel;
    }
}