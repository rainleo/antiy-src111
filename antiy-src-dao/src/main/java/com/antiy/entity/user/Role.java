package com.antiy.entity.user;


/**
 * <p>角色表</p>
 *
 * @author wq
 * @since 2020-02-05
 */

public class Role {


private static final long serialVersionUID = 1L;
    private Integer id;
    /**
    *  角色名称
    */
    private String name;
    /**
    *  角色标识
    */
    private String tag;
    /**
    *  描述
    */
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
            return "Role{" +
                        ", name=" + name +
                        ", tag=" + tag +
                        ", description=" + description +
            "}";
    }
}