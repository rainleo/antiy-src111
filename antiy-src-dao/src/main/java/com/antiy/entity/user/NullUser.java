package com.antiy.entity.user;


/**
 * 空用户对象对象
 * @author zhouye
 * @date 2019-07-29
 */
public class NullUser extends User {
	public NullUser() {
		this.setUsername("");
		this.setName("");
		this.setBh("");
	}
	public NullUser(String username, String name, String bh) {
		this.setUsername(username);
		this.setName(name);
		this.setBh(bh);
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
