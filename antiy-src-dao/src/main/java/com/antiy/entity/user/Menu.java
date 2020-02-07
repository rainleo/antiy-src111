package com.antiy.entity.user;


/**
 * <p>菜单表</p>
 *
 * @author wq
 * @since 2020-02-05
 */

public class Menu {


private static final long serialVersionUID = 1L;

    private Integer id;
    /**
    *  父id
    */
    private Integer parentId;
    /**
    *  名称
    */
    private String name;
    /**
    *  菜单标识
    */
    private String tag;
    /**
    *  菜单类型 1、菜单 2、按钮
    */
    private Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }


    @Override
    public String toString() {
            return "Menu{" +
                        ", parentId=" + parentId +
                        ", name=" + name +
                        ", tag=" + tag +
                        ", type=" + type +
            "}";
    }
}