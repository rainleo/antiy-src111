package com.antiy.entity.user;


import java.util.List;

/**
 * @author zhouye
 * 当前登录用户信息
 */
public class LoginUser {
	public LoginUser() {
	}

	public LoginUser(Long businessId, String username, String name, Integer departmentId) {
		this.businessId = businessId;
		this.username = username;
		this.name = name;
		this.departmentId = departmentId;
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

	private Integer departmentId;

	private List<String> menus;

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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

    public List<String> getMenus() {
        return menus;
    }

    public void setMenus(List<String> menus) {
        this.menus = menus;
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
