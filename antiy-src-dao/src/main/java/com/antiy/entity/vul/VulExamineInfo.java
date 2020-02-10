package com.antiy.entity.vul;

/**
 * <p></p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class VulExamineInfo {

    private Integer id;
    private String  vulId;
    private Long    examiner;
    /**
     * 2通过3未通过
     */
    private Integer result;
    private String  reason;
    private String  examineMaterialName;
    private String  examineMaterialUrl;
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

    public Long getExaminer() {
        return examiner;
    }

    public void setExaminer(Long examiner) {
        this.examiner = examiner;
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

    public VulExamineInfo(Integer id, String vulId, Long examiner, Integer result, String reason,
                          String examineMaterialName, String examineMaterialUrl, Long examineDate) {
        this.id = id;
        this.vulId = vulId;
        this.examiner = examiner;
        this.result = result;
        this.reason = reason;
        this.examineMaterialName = examineMaterialName;
        this.examineMaterialUrl = examineMaterialUrl;
        this.examineDate = examineDate;
    }
}