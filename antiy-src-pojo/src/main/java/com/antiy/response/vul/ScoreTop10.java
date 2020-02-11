package com.antiy.response.vul;
/**
 * @program antiy-src-parent
 * @description 
 * @author wangqian
 * created on 2020-02-11
 * @version  1.0.0
 */
public class ScoreTop10 {

    /**
     * 姓名
     */
    private String name;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 积分数
     */
    private Long score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }
}
