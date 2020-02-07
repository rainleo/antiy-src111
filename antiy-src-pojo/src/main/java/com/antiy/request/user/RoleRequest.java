package com.antiy.request.user;

import com.antiy.exception.RequestParamValidateException;
import com.antiy.request.BaseRequest;
import com.antiy.validation.ObjectValidator;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * RoleRequest 请求对象
 * </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */

public class RoleRequest extends BaseRequest implements ObjectValidator {

    /**
     *  角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;
    /**
     *  角色标识
     */
    @ApiModelProperty("角色标识")
    private String tag;
    /**
     *  描述
     */
    @ApiModelProperty("描述")
    private String description;



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
    public void validate() throws RequestParamValidateException {

    }

}