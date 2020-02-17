package com.antiy.response.vul;

public class SseVulResponse {
    /**
     * 漏洞id
     */
    private Integer vulId;
    /**
     * 漏洞名
     */
    private String  vulName;
    /**
     * 提交日期
     */
    private Long    commitDate;
    /**
     * 提示消息
     */
    private String  notice;

    public SseVulResponse() {
    }

    public SseVulResponse(Integer vulId, String vulName, Long commitDate, String notice) {
        this.vulId = vulId;
        this.vulName = vulName;
        this.commitDate = commitDate;
        this.notice = notice;
    }

    public Integer getVulId() {
        return vulId;
    }

    public void setVulId(Integer vulId) {
        this.vulId = vulId;
    }

    public String getVulName() {
        return vulName;
    }

    public void setVulName(String vulName) {
        this.vulName = vulName;
    }

    public Long getCommitDate() {
        return commitDate;
    }

    public void setCommitDate(Long commitDate) {
        this.commitDate = commitDate;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }
}
