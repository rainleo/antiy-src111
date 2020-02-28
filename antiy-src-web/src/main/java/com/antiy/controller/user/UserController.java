package com.antiy.controller.user;

import com.alibaba.fastjson.JSON;
import com.antiy.base.ActionResponse;
import com.antiy.base.PageResult;
import com.antiy.base.RespBasicCode;
import com.antiy.common.utils.AesEncryptUtil;
import com.antiy.consts.UserConstant;
import com.antiy.entity.user.TaskIdQuery;
import com.antiy.entity.user.User;
import com.antiy.query.user.BusinessIdQuery;
import com.antiy.query.user.ScoreQuery;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.Add;
import com.antiy.request.user.NormalUserRequest;
import com.antiy.request.user.Update;
import com.antiy.request.user.UserPasswordRequest;
import com.antiy.request.user.UserRequest;
import com.antiy.response.user.UserResponse;
import com.antiy.service.user.IUserService;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.code.ValidateImageCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private LoginUserUtil loginUserUtil;

    @ApiOperation("创建用户")
    @PostMapping("/save")
    public ActionResponse addUser(@Validated(value = Add.class) @RequestBody UserRequest request) throws Exception {
        AesEncryptUtil.aesDecrypt(request.getPassword());
        userService.saveUser(request);
        return ActionResponse.success();
    }

    @ApiOperation("普通用户注册")
    @PostMapping("/register")
    public ActionResponse register(@Validated(value = Add.class) @RequestBody NormalUserRequest request, HttpServletRequest httpServletRequest) throws Exception {
        ActionResponse response;
        if (ValidateImageCode.validate(httpServletRequest, request.getCode())) {
            AesEncryptUtil.aesDecrypt(request.getPassword());
            response = ActionResponse.success(userService.register(request));
        } else {
            logger.warn("用户验证码输入错误");
            response = ActionResponse.fail(RespBasicCode.IMAGE_CODE_ERROR, RespBasicCode.IMAGE_CODE_ERROR.getResultDes());
        }
        return response;
    }

    @ApiOperation("修改用户")
    @PostMapping("/update")
    public ActionResponse updateUser(@Validated(value = Update.class) @RequestBody UserRequest request) throws Exception {
        logger.info("修改用户入参:{}", JSON.toJSONString(request));
        userService.updateUser(request);
        return ActionResponse.success();
    }

    @ApiOperation("查看用户")
    @PostMapping("/detail")
    public ActionResponse viewUser(@RequestBody BusinessIdQuery query) throws Exception {
        logger.info("查看用户入参:{}", JSON.toJSONString(query));
        UserResponse response = userService.queryUserByBussinessId(query.getBussinessId());
        return ActionResponse.success(response);
    }

    @ApiOperation("管理员重置用户密码(只传新密码)")
    @PostMapping("/adminResetPwd")
    public ActionResponse adminResetPwd(@RequestBody UserPasswordRequest request) throws Exception {
        logger.info("管理员重置用户密码(只传新密码)入参:{}", JSON.toJSONString(request));
        AesEncryptUtil.aesDecrypt(request.getNewPassword());
        userService.updatePassword(request.getBusinessId(), request.getNewPassword());
        return ActionResponse.success();
    }

    @ApiOperation("用户自己修改密码(新旧密码都传)")
    @PostMapping("/userResetPwd")
    public ActionResponse userResetPwd(@RequestBody UserPasswordRequest request) throws Exception {
        logger.info("用户自己修改密码(新旧密码都传)入参:{}", JSON.toJSONString(request));
        AesEncryptUtil.aesDecrypt(request.getNewPassword());
        AesEncryptUtil.aesDecrypt(request.getOldPassword());
        userService.updatePassword(request.getBusinessId(), request.getOldPassword(), request.getNewPassword());
        return ActionResponse.success();
    }

    @ApiOperation("用户列表")
    @PostMapping("/list")
    public ActionResponse userList(@RequestBody(required = false) UserQuery query) {
        logger.info("用户列表入参:{}", JSON.toJSONString(query));
        Integer roleId = loginUserUtil.getUser().getRoleId();
        if (UserConstant.ROLE_TYPE_SUPERADMIN.equals(roleId)) {
            query.setAdmin(true);
        }
        PageResult<User> page = userService.findPage(query);
        List<User> users = page.getItems();
        List<UserResponse> reps = new ArrayList<>();
        for (User user : users) {
            UserResponse r = new UserResponse();
            BeanUtils.copyProperties(user, r);
            String idcard = r.getIdcard();
            if (StringUtils.isNotBlank(idcard) && idcard.length() >= 15) {
                String tm;
                String rep;
                if (idcard.length() == 18) {
                     tm = idcard.substring(6, 14);
                     rep = "********";
                } else {
                     tm = idcard.substring(6, 12);
                    rep = "******";
                }
                r.setIdcard(idcard.substring(0, 6) + rep + (idcard.substring(rep.length() + 6)));
            }
            r.setBusinessId(user.getBusinessId().toString());
            reps.add(r);
        }
        PageResult<UserResponse> result = new PageResult(page.getPageSize(),page.getTotalRecords(),page.getCurrentPage(),reps);
        return ActionResponse.success(result);
    }


    @ApiOperation("部门下拉列表")
    @PostMapping("/getDepartmentList")
    public ActionResponse getDepartmentList() {
        return ActionResponse.success(userService.getDepartmentList());
    }

    @ApiOperation("获得个人积分明细列表")
    @PostMapping("/getScoreList")
    public ActionResponse getScoreList(@RequestBody ScoreQuery query) {
        return ActionResponse.success(userService.getScoreList(query));
    }

    @ApiOperation("获得个人总积分")
    @PostMapping("/getScore")
    public ActionResponse getScore() {
        return ActionResponse.success(userService.getTotalScore());
    }

    @ApiOperation("获得个人积分top10")
    @PostMapping("/userScoreTop10")
    public ActionResponse userScoreTop10(@RequestBody(required = false) TaskIdQuery query) {
        return ActionResponse.success(userService.userScoreTop10(query));
    }

    @ApiOperation("获得部门积分top10")
    @PostMapping("/departmentScoreTop10")
    public ActionResponse departmentScoreTop10(@RequestBody(required = false) TaskIdQuery query) {
        return ActionResponse.success(userService.departmentScoreTop10(query));
    }

    @ApiOperation("提交漏洞走势图")
    @PostMapping("/vulSubmitTrend")
    public ActionResponse vulSubmitTrend(@RequestBody(required = false) TaskIdQuery query) {
        return ActionResponse.success(userService.vulSubmitTrend(query));
    }

    @ApiOperation("修复漏洞走势图")
    @PostMapping("/vulRepairTrend")
    public ActionResponse vulRepairTrend(@RequestBody(required = false) TaskIdQuery query) {
        return ActionResponse.success(userService.vulRepairTrend(query));
    }

    @ApiOperation("用户下拉选择数据")
    @PostMapping("/userDownList")
    public ActionResponse userDownList() {
        return ActionResponse.success(userService.getNormalUserList());
    }
}
