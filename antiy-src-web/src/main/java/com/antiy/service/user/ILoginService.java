package com.antiy.service.user;

import com.antiy.base.ActionResponse;
import com.antiy.entity.user.User;

public interface ILoginService {

	 ActionResponse login(User user);

	/**
	 * 注销用户登录状态
	 * @param token token
	 * @return 响应
	 */
	ActionResponse logout(String token);

}
