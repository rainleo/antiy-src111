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
	private Long businessId;
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
	 * 所属单位
	 */
	private Integer department;

    /**
     * 联系电话
	 */
	private String phone;

	/**
	 * 最后一次登陆时间
	 */
	private Long lastLoginTime;

	/**
	 * 创建时间
	 */
	private Long gmtCreate;

	/**
	 * 菜单标识集合
	 */
	private List<String> menus;


	public Integer getDepartment() {
		return department;
	}

	public void setDepartment(Integer department) {
		this.department = department;
	}

	public Long getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Long businessId) {
		this.businessId = businessId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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
				"businessId='" + businessId + '\'' +
				", username='" + username + '\'' +
				", name='" + name + '\'' +
				", department='" + department + '\'' +
				", status=" + status +
				", phone='" + phone + '\'' +
				", lastLoginTime=" + lastLoginTime +
				", gmtCreate=" + gmtCreate +
				", menus=" + menus +
				'}';
	}
}
