package com.antiy.controller.user;

import com.antiy.annotation.HavePermission;
import com.antiy.base.ActionResponse;
import com.antiy.base.RespBasicCode;
import com.antiy.common.utils.LogUtils;
import com.antiy.entity.user.User;
import com.antiy.request.user.UserLoginRequest;
import com.antiy.service.user.ILoginService;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.code.ValidateImageCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouye
 * @date 2019-07-29
 */
@RestController
@Api(description = "用户登录")
@RequestMapping("/api/v1/user")
public class LoginController {
	private Logger log = LogUtils.get(this.getClass());
	@Resource
	private ILoginService loginService;
	@Resource
	private LoginUserUtil loginUserUtil;
	@ApiOperation("用户登录")
	@PostMapping("/login")
	public ActionResponse login(@RequestBody UserLoginRequest loginRequest, HttpServletRequest servletRequest) {
		Long startTime = System.currentTimeMillis();
		ActionResponse response;
		if (ValidateImageCode.validate(servletRequest, loginRequest.getCode())) {
			if(ValidateImageCode.IsExpired(servletRequest)){
				response = ActionResponse.fail(RespBasicCode.IMAGE_CODE_EXPRIED, RespBasicCode.IMAGE_CODE_EXPRIED.getResultDes());
			}else {
				log.info("校验验证码耗时"+(System.currentTimeMillis()-startTime)+" ms");
				User user = new User();
				BeanUtils.copyProperties(loginRequest, user);
				response = loginService.login(user);
			}
		} else {
			log.warn("用户验证码输入错误{}", loginRequest.toString());
			response = ActionResponse.fail(RespBasicCode.IMAGE_CODE_ERROR, RespBasicCode.IMAGE_CODE_ERROR.getResultDes());
		}
		Long endTime = System.currentTimeMillis();
		log.info("登录接口耗时：" + (endTime-startTime)+" ms");
		return response;
	}
	@ApiOperation("用户注销")
	@PostMapping("/logout")
	public ActionResponse logout(@RequestHeader(value="token") String token) {
		log.info("须注销token："+token);
		loginService.logout(token);
		loginUserUtil.setUser(null);
		return ActionResponse.success();
	}

	@HavePermission("user:add:sh")
	@ApiOperation("用户认证状态是否有效，测试接口")
	@PostMapping("/isAuth")
	public ActionResponse isAuth() {
		return ActionResponse.success(loginUserUtil.getUser());
	}
}
