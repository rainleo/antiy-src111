package com.antiy.entity.vul;
/**
 * @program antiy-src-parent
 * @description 事件等级
 * @author wangqian
 * created on 2020-02-13
 * @version  1.0.0
 */
public class EventLevel {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 级别
     */
    private String level;
    /**
     * 事件内容
     */
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
