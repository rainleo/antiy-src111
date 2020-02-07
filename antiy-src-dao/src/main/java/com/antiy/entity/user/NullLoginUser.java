package com.antiy.entity.user;


/**
 * 空用户对象对象
 * @author zhouye
 * @date 2019-07-29
 */
public class NullLoginUser extends LoginUser {
	public NullLoginUser() {
		this.setUsername("");
		this.setName("");
	}
	public NullLoginUser(String username, String name, Long businessId) {
		this.setUsername(username);
		this.setName(name);
		this.setBusinessId(businessId);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
