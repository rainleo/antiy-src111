package com.antiy.request.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangqian
 * created on 2019-07-25
 * @version 1.0.0
 * @program kbms-parent
 * @description 用户
 */
@ApiModel
public class UserRequest {

    @ApiModelProperty("主键")
    private String bh;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("电子邮箱")
    private String email;

    @ApiModelProperty("功能主键集合")
    private List<String> menuBhs;

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getMenuBhs() {
        return menuBhs;
    }

    public void setMenuBhs(List<String> menuBhs) {
        this.menuBhs = menuBhs;
    }
}
