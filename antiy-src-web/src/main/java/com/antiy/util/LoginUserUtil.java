package com.antiy.util;

import com.antiy.common.utils.LogUtils;
import com.antiy.entity.user.LoginUser;
import com.antiy.entity.user.NullLoginUser;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author zhouye
 * @date 2019-07-30
 * 获取当前能录用户信息
 * 如果没有则返回内置系统对象
 * 注：请使用Spring容器此类的bean
 */
@Component
public class LoginUserUtil {
	private static ThreadLocal<LoginUser> threadLocal = new ThreadLocal<>();
	public LoginUserUtil() {
	}

	public LoginUser getUser() {
		return getLoginUserFromThreadLocal();
	}

	/**
	 * 判断是否为内置系统对象 true-是
	 *
	 * @return 布尔值
	 */
	public Boolean isSystem() {
		LoginUser result = getLoginUserFromThreadLocal();
		return result instanceof NullLoginUser;
	}

	public void setUser(LoginUser user) {
		Logger log = LogUtils.get(this.getClass());
		if (user !=null) {
			log.debug("设置缓存中的用户信息{}", user);
		}
		threadLocal.set(user);
	}

	private LoginUser getLoginUserFromThreadLocal() {
		Logger log = LogUtils.get(this.getClass());
		LoginUser result=threadLocal.get();
		if ( result == null) {
			result = new NullLoginUser("SYSTEM", "系统", "0");
			threadLocal.set(result);
		}
		log.debug("业务代码获取当前登录用户:{}信息",result);
		return result;
	}
}
