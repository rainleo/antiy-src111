package com.antiy.query.user;


import com.antiy.base.ObjectQuery;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

/**
 * <p>
 * User 查询条件
 * </p>
 *
 * @author zhangyajun
 * @since 2018-12-27
 */

public class UserQuery extends ObjectQuery {

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("姓名")
    private String name;

    public String getUsername() {
        if (StringUtils.isNotBlank(username)) {
            return username.replaceAll("[%|_]", "&");
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        if (StringUtils.isNotBlank(name)) {
            return name.replaceAll("[%|_]", "&");
        }
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}