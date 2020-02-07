package com.antiy.request.vul;


import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * VulExamineInfoRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class VulExamineInfoRequest implements ObjectValidator {

    @ApiModelProperty("")
    private String vulNo;
    @ApiModelProperty("")
    private Integer examiner;
    /**
     * 2通过3未通过
     */
    @ApiModelProperty("2通过3未通过")
    private Integer result;
    @ApiModelProperty("")
    private String reason;
    @ApiModelProperty("")
    private String examineMaterialName;
    @ApiModelProperty("")
    private String examineMaterialUrl;
    @ApiModelProperty("")
    private Long examineDate;


    public String getVulNo() {
        return vulNo;
    }

    public void setVulNo(String vulNo) {
        this.vulNo = vulNo;
    }


    public Integer getExaminer() {
        return examiner;
    }

    public void setExaminer(Integer examiner) {
        this.examiner = examiner;
    }


    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
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
    public void validate() throws RequestParamValidateException {

    }

}