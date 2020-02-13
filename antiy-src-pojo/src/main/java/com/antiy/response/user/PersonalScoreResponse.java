package com.antiy.response.user;


import com.antiy.response.vul.VulIntegralInfoResponse;

import java.util.List;

/**
 * @program antiy-src-parent
 * @description 个人积分
 * @author wangqian
 * created on 2020-02-11
 * @version  1.0.0
 */
public class PersonalScoreResponse {
    private Long totalScore;
    private List<VulIntegralInfoResponse> details;

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }

    public List<VulIntegralInfoResponse> getDetails() {
        return details;
    }

    public void setDetails(List<VulIntegralInfoResponse> details) {
        this.details = details;
    }
}
