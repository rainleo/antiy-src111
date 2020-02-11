package com.antiy.response.vul;

import com.antiy.enums.user.ExamineEnum;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p> VulExamineInfoResponse 响应对象 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulExamineInfoResponse {
    @ApiModelProperty("主键")
    private Integer id;
    @ApiModelProperty("漏洞id")
    private String  vulId;
    @ApiModelProperty("审批人")
    private Long    examiner;
    @ApiModelProperty("审批意见")
    private String  result;
    @ApiModelProperty("审核利用")
    private String  reason;
    @ApiModelProperty("审核材料名称")
    private String  examineMaterialName;
    @ApiModelProperty("审批材料路径")
    private String  examineMaterialUrl;
    @ApiModelProperty("审核时间")
    private Long    examineDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVulId() {
        return vulId;
    }

    public void setVulId(String vulId) {
        this.vulId = vulId;
    }

    public Long getExaminer() {
        return examiner;
    }

    public void setExaminer(Long examiner) {
        this.examiner = examiner;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = ExamineEnum.getMsg(Integer.parseInt(result));
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getExamineMaterialName() {
        return examineMaterialName;
    }

    public void setExamineMaterialName(String examineMaterialName) {
        this.examineMaterialName = examineMaterialName;
    }

    public String getExamineMaterialUrl() {
        return examineMaterialUrl;
    }

    public void setExamineMaterialUrl(String examineMaterialUrl) {
        this.examineMaterialUrl = examineMaterialUrl;
    }

    public Long getExamineDate() {
        return examineDate;
    }

    public void setExamineDate(Long examineDate) {
        this.examineDate = examineDate;
    }

    @Override
    public String toString() {
        return "VulExamineInfoResponse{" + "id=" + id + ", vulId='" + vulId + '\'' + ", examiner=" + examiner
               + ", result='" + result + '\'' + ", reason='" + reason + '\'' + ", examineMaterialName='"
               + examineMaterialName + '\'' + ", examineMaterialUrl='" + examineMaterialUrl + '\'' + ", examineDate="
               + examineDate + '}';
    }
}