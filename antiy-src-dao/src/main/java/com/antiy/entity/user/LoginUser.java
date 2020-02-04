package com.antiy.entity.user;


/**
 * @author zhouye
 * 当前登录用户信息
 */
public class LoginUser {
	public LoginUser() {
	}

	public LoginUser(String bh, String username, String name) {
		this.bh = bh;
		this.username = username;
		this.name = name;
	}

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

	@Override
	public String toString() {
		return "LoginUser{" +
				"bh='" + bh + '\'' +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
