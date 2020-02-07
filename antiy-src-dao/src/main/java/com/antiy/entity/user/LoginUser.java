package com.antiy.entity.user;


/**
 * @author zhouye
 * 当前登录用户信息
 */
public class LoginUser {
	public LoginUser() {
	}

	public LoginUser(Long businessId, String username, String name) {
		this.businessId = businessId;
		this.username = username;
		this.name = name;
	}

	/**
	 * 用户标识
	 */
	private Long businessId;
	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 姓名
	 */
	private String name;

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
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

	@Override
	public String toString() {
		return "LoginUser{" +
				"bh='" + businessId + '\'' +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
