package com.antiy.entity.vul;


/**
 * <p></p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulExamineInfo {


    private static final long serialVersionUID = 1L;
    private Integer id;
    private String vulNo;
    private Integer examiner;
    /**
     * 2通过3未通过
     */
    private Integer result;
    private String reason;
    private String examineMaterialName;
    private String examineMaterialUrl;
    private Long examineDate;

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
    public String toString() {
        return "VulExamineInfo{" +
                "id=" + id +
                ", vulNo='" + vulNo + '\'' +
                ", examiner=" + examiner +
                ", result=" + result +
                ", reason='" + reason + '\'' +
                ", examineMaterialName='" + examineMaterialName + '\'' +
                ", examineMaterialUrl='" + examineMaterialUrl + '\'' +
                ", examineDate=" + examineDate +
                '}';
    }
}