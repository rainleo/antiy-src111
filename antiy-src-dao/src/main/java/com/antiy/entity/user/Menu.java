package com.antiy.entity.user;


import java.util.List;
import java.util.Objects;

/**
 * <p>功能权限</p>
 *
 * @author wangqian
 * @since 2019-07-25
 */

public class Menu {


    private static final long serialVersionUID = 1L;

    /**
     * 功能编号
     */
    private String bh;
    /**
     * 父编号
     */
    private String parentBh;
    /**
     * 功能名称
     */
    private String name;
    /**
     * 功能标识
     */
    private String tag;
    /**
     * 功能类型1、菜单 2、功能按钮
     */
    private Integer type;

    private List<Menu> childs;


    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }


    public String getParentBh() {
        return parentBh;
    }

    public void setParentBh(String parentBh) {
        this.parentBh = parentBh;
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

    public List<Menu> getChilds() {
        return childs;
    }

    public void setChilds(List<Menu> childs) {
        this.childs = childs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Menu menu = (Menu) o;
        return Objects.equals(bh, menu.bh) &&
                Objects.equals(parentBh, menu.parentBh) &&
                Objects.equals(name, menu.name) &&
                Objects.equals(tag, menu.tag) &&
                Objects.equals(type, menu.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bh, parentBh, name, tag, type);
    }

    @Override
    public String toString() {
        return "Menu{" +
                ", bh=" + bh +
                ", parentBh=" + parentBh +
                ", name=" + name +
                ", tag=" + tag +
                ", type=" + type +
                "}";
    }
}