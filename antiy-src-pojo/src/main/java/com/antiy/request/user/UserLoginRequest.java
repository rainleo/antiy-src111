package com.antiy.request.user;

import com.antiy.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhouye
 * 用户登录Request
 *
 */
public class UserLoginRequest extends BasicRequest {
	/**
	 * 用户名
	 */
	@NotEmpty(message = "用户名不能为空")
	@ApiModelProperty("用户名")
	private String username;
	/**
	 * 密码
	 */
	@NotEmpty(message = "密码不能为空")
	@ApiModelProperty("密码")
	private String password;
	/**
	 * 验证码
	 */
	@NotEmpty(message = "验证码不能为空")
	@ApiModelProperty("验证码")
	private String code;

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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "UserLoginRequest{" +
				"username='" + username + '\'' +
				", password='" + password + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
