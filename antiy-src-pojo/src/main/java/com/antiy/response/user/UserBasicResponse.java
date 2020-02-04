package com.antiy.response.user;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author zhouye
 * 登录后用户基本信息返回
 */
public class UserBasicResponse {

	/**
	 * 用户标识
	 */
	private String bh;
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 姓名
	 */
	private String name;

	@ApiModelProperty("状态")
	private Integer status;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 最后一次登陆时间
	 */
	private Long lastLoginTime;

	/**
	 * 创建时间
	 */
	private Long gmtCreate;

	/**
	 * 菜单编号集合
	 */
	private List<String> menus;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public Long getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Long gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

	@Override
	public String toString() {
		return "UserBasicResponse{" +
				"bh='" + bh + '\'' +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", status=" + status +
				", email='" + email + '\'' +
				", lastLoginTime=" + lastLoginTime +
				", gmtCreate=" + gmtCreate +
				", menus=" + menus +
				'}';
	}
}
