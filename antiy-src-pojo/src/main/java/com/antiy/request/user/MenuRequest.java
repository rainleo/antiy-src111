package com.antiy.request.user;

import com.antiy.exception.RequestParamValidateException;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * MenuRequest 请求对象
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class MenuRequest implements ObjectValidator {

    /**
     *  父id
     */
    @ApiModelProperty("父id")
    private Integer parentId;
    /**
     *  名称
     */
    @ApiModelProperty("名称")
    private String name;
    /**
     *  菜单标识
     */
    @ApiModelProperty("菜单标识")
    private String tag;
    /**
     *  菜单类型 1、菜单 2、按钮
     */
    @ApiModelProperty("菜单类型 1、菜单 2、按钮")
    private Integer type;



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
    public void validate() throws RequestParamValidateException {

    }

}