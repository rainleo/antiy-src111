package com.antiy.controller.user;

import com.alibaba.fastjson.JSON;
import com.antiy.base.ActionResponse;
import com.antiy.common.utils.AesEncryptUtil;
import com.antiy.entity.user.Menu;
import com.antiy.query.user.BhQuery;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.UserPasswordRequest;
import com.antiy.request.user.UserRequest;
import com.antiy.request.user.UserStatusRequest;
import com.antiy.response.user.UserResponse;
import com.antiy.service.user.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program kbms-parent
 * @description 用户api
 * @author wangqian
 * created on 2019-07-25
 * @version  1.0.0
 */
@RestController
@Api(description = "用户管理")
@RequestMapping("/api/v1/user")
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @ApiOperation("增加用户")
    @PostMapping("/save")
    public ActionResponse addUser(@RequestBody UserRequest request) throws Exception {
        logger.info("增加用户入参:{}", JSON.toJSONString(request));
        AesEncryptUtil.aesDecrypt(request.getPassword());
        userService.saveUser(request);
        return ActionResponse.success();
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public ActionResponse updateUser(@RequestBody UserRequest request) {
        logger.info("修改用户入参:{}", JSON.toJSONString(request));
        userService.updateUser(request);
        return ActionResponse.success();
    }

    @ApiOperation("查看用户")
    @PostMapping("/detail")
    public ActionResponse viewUser(@RequestBody BhQuery bhQuery) {
        logger.info("查看用户入参:{}", JSON.toJSONString(bhQuery));
        UserResponse response = userService.getUserByBh(bhQuery.getBh());
        return ActionResponse.success(response);
    }

    @ApiOperation("禁用/启用用户")
    @PostMapping("/updateStatus")
    public ActionResponse updateStatus(@RequestBody UserStatusRequest request) {
        logger.info("禁用/启用用户入参:{}", JSON.toJSONString(request));
        userService.updateUserStatus(request.getBh(), request.getStatus());
        return ActionResponse.success();
    }

    @ApiOperation("管理员重置用户密码(只传新密码)")
    @PostMapping("/adminResetPwd")
    public ActionResponse adminResetPwd(@RequestBody UserPasswordRequest request) throws Exception {
        logger.info("管理员重置用户密码(只传新密码)入参:{}", JSON.toJSONString(request));
        AesEncryptUtil.aesDecrypt(request.getNewPassword());
        userService.updatePassword(request.getBh(), request.getNewPassword());
        return ActionResponse.success();
    }

    @ApiOperation("用户自己修改密码(新旧密码都传)")
    @PostMapping("/userResetPwd")
    public ActionResponse userResetPwd(@RequestBody UserPasswordRequest request) throws Exception {
        logger.info("用户自己修改密码(新旧密码都传)入参:{}", JSON.toJSONString(request));
        AesEncryptUtil.aesDecrypt(request.getNewPassword());
        AesEncryptUtil.aesDecrypt(request.getOldPassword());
        userService.updatePassword(request.getBh(), request.getOldPassword(), request.getNewPassword());
        return ActionResponse.success();
    }

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public ActionResponse userList(@RequestBody(required = false) UserQuery query) {
        logger.info("用户列表入参:{}", JSON.toJSONString(query));
        return ActionResponse.success(userService.findPage(query));
    }

    @ApiOperation("菜单树查询")
    @PostMapping("/menuTree")
    public ActionResponse menuTree() {
        Menu menu = userService.getMenuTree();
        return ActionResponse.success(menu);
    }
}
