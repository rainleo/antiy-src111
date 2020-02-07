package com.antiy.enums.user;

/**
 * 用户状态
 */
public enum  UserStatus {
	/**
	 * 正常
	 */
	normal(1),
	/**
	 * 禁用
	 */
	forbidden(0),
	/**
	 * 锁定
	 */
	locked(2);
	private Integer code;

	UserStatus(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}}
