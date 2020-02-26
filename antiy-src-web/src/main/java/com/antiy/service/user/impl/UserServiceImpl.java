package com.antiy.service.user.impl;

import com.antiy.base.BaseConverter;
import com.antiy.base.PageResult;
import com.antiy.common.base.BaseServiceImpl;
import com.antiy.common.utils.LogUtils;
import com.antiy.consts.UserConstant;
import com.antiy.dao.user.RoleDao;
import com.antiy.dao.user.UserDao;
import com.antiy.dao.vul.TaskInfoDao;
import com.antiy.dao.vul.VulInfoDao;
import com.antiy.dao.vul.VulIntegralInfoDao;
import com.antiy.entity.user.Department;
import com.antiy.entity.user.LoginUser;
import com.antiy.entity.user.NullLoginUser;
import com.antiy.entity.user.TaskIdQuery;
import com.antiy.entity.user.User;
import com.antiy.entity.vul.EventLevel;
import com.antiy.entity.vul.TaskInfo;
import com.antiy.entity.vul.VulIntegralInfo;
import com.antiy.exception.BusinessException;
import com.antiy.query.user.ScoreQuery;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.BussinessIdRequest;
import com.antiy.request.user.NormalUserRequest;
import com.antiy.request.user.UserRequest;
import com.antiy.response.user.UserResponse;
import com.antiy.response.vul.ScoreTop10;
import com.antiy.response.vul.VulIntegralInfoResponse;
import com.antiy.service.user.IUserService;
import com.antiy.util.DateUtil;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.SnowFlake;
import com.antiy.util.TokenStoreUtil;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    private Logger logger = LogUtils.get(this.getClass());

    @Resource
    private UserDao userDao;
    @Resource
    private RoleDao roleDao;
    @Resource
    private TaskInfoDao taskInfoDao;
    @Resource
    private VulIntegralInfoDao vulIntegralInfoDao;
    @Resource
    private VulInfoDao vulInfoDao;
    @Resource
    private BaseConverter<UserRequest, User> requestConverter;
    @Resource
    private BaseConverter<User, UserResponse> responseConverter;
    @Resource
    private BaseConverter<VulIntegralInfo, VulIntegralInfoResponse> vulIntegralInfoResponseConverter;
    @Autowired
    private LoginUserUtil loginUserUtil = new LoginUserUtil();

    @Override
    public String saveUser(UserRequest request) throws Exception {
        LoginUser curUser = loginUserUtil.getUser();
        if (curUser instanceof NullLoginUser) {
            throw new BusinessException("当前用户不存在");
        }
        Integer roleId = roleDao.findRoleIdByUserId(curUser.getBusinessId());
        Integer requestRole = request.getRoleType();
        if (requestRole != null) {
            //超级管理员才能创建管理员
            if (UserConstant.ROLE_TYPE_ADMIN.equals(requestRole)
                    && !UserConstant.ROLE_TYPE_SUPERADMIN.equals(roleId)) {
                throw new BusinessException("您没有创建管理员的权限");
            }
            //超级管理员和管理员才能创建审核员
            if (UserConstant.ROLE_TYPE_SH.equals(requestRole)
                    && !UserConstant.ROLE_TYPE_SUPERADMIN.equals(roleId)
                    && !UserConstant.ROLE_TYPE_ADMIN.equals(roleId)) {
                throw new BusinessException("您没有创建审核员的权限");
            }
        }
        User user = new User();
        int num = userDao.findCountByUsername(request.getUsername());
        logger.info("检查用户名是否重复");
        if (num > 0) {
            logger.info("用户名已存在");
            throw new BusinessException(UserConstant.USERNAME_EXIST);
        }
        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new BusinessException("确认密码和密码字段不一致，请检查！");
        }
        BeanUtils.copyProperties(request, user);
        user.setBusinessId(new SnowFlake(0, 0).nextId());
        user.setStatus(UserConstant.USER_STATUS_NORMAL);
        user.setCreateUser(1111L);
        user.setGmtCreate(System.currentTimeMillis());
        userDao.insert(user);
        Map<String, Object> param = new HashMap<>(2);
        param.put("userId", user.getBusinessId());
        param.put("roleId", requestRole != null ? requestRole : 4);
        roleDao.saveUserRole(param);
        logger.info("创建用户成功");
        return user.getBusinessId().toString();
    }

    @Override
    public String register(NormalUserRequest request) {
        User user = new User();
        int num = userDao.findCountByUsername(request.getUsername());
        logger.info("检查用户名是否重复");
        if (num > 0) {
            logger.info("用户名已存在");
            throw new BusinessException(UserConstant.USERNAME_EXIST);
        }
        if (!request.getPassword().equals(request.getRepeatPassword())) {
            throw new BusinessException("确认密码和密码字段不一致，请检查！");
        }
        BeanUtils.copyProperties(request, user);
        user.setBusinessId(new SnowFlake(0, 0).nextId());
        user.setStatus(UserConstant.USER_STATUS_NORMAL);
        user.setGmtCreate(System.currentTimeMillis());
        userDao.insert(user);
        Map<String, Object> param = new HashMap<>(2);
        param.put("userId", user.getBusinessId());
        param.put("roleId", 4);
        roleDao.saveUserRole(param);
        logger.info("创建用户成功");
        return user.getBusinessId().toString();
    }



    @Override
    public String updateUser(UserRequest request) throws Exception {
        request.setUsername(null);
        request.setPassword(null);
        User user = requestConverter.convert(request, User.class);
        return userDao.update(user).toString();
    }

    @Override
    public void updatePassword(Long businessId, String newPassword) throws Exception {
        userDao.updateUserPassword(businessId, newPassword);
        TokenStoreUtil.removeToken(businessId);
        logger.info("管理员更新用户密码成功");
    }

    @Override
    public void updatePassword(Long businessId, String oldPassword, String newPassword) throws Exception {
        logger.info("用户修改密码开始");
        User user = userDao.getById(businessId);
        if (!oldPassword.equals(user.getPassword())) {
            logger.info("用户修改密码旧密码错误");
            throw new BusinessException("原密码不正确");
        }
        userDao.updateUserPassword(businessId, newPassword);
        logger.info("用户修改密码成功");
    }

    @Override
    public List<UserResponse> queryListUser(UserQuery query) throws Exception {
        List<User> userList = userDao.findQuery(query);
        //TODO
        return responseConverter.convert(userList, UserResponse.class);
    }

    @Override
    public PageResult<UserResponse> queryPageUser(UserQuery query) throws Exception {
        return new PageResult<UserResponse>(query.getPageSize(), this.findCount(query), query.getCurrentPage(), this.queryListUser(query));
    }

    @Override
    public UserResponse queryUserByBussinessId(Long businessId) throws Exception {
        User user = userDao.getById(businessId);
        UserResponse userResponse = responseConverter
                .convert(user, UserResponse.class);
        userResponse.setBusinessId(user.getBusinessId().toString());
        return userResponse;
    }

    @Override
    public String deleteUserById(BussinessIdRequest baseRequest) throws Exception {
        return userDao.deleteById(baseRequest.getBusinessId()).toString();
    }

    @Override
    public List<Department> getDepartmentList() {
        return userDao.getDepartmentList();
    }

    @Override
    public PageResult<VulIntegralInfoResponse> getScoreList(ScoreQuery query) {
        LoginUser user = loginUserUtil.getUser();
        long userId = user.getBusinessId();
        query.setUserId(userId);
        Integer count = vulIntegralInfoDao.findCountScore(query);
        List<VulIntegralInfo> scoreList = vulIntegralInfoDao.getScoreList(query);
        return new PageResult<>(query.getPageSize(), count, query.getCurrentPage(),
                vulIntegralInfoResponseConverter.convert(scoreList, VulIntegralInfoResponse.class));
    }

    @Override
    public Integer getTotalScore() {
        LoginUser user = loginUserUtil.getUser();
        long userId = user.getBusinessId();
        return vulIntegralInfoDao.getScoreOfUser(userId);
    }

    @Override
    public List<ScoreTop10> userScoreTop10(TaskIdQuery query) {
        long start = DateUtil.getBefore30Day();
        long end = DateUtil.getToday235959();
        return vulIntegralInfoDao.getPersonalTop10(start, end, query.getTaskId());
    }

    @Override
    public List<ScoreTop10> departmentScoreTop10(TaskIdQuery query) {
        long start = DateUtil.getBefore30Day();
        long end = DateUtil.getToday235959();
        return vulIntegralInfoDao.getDepartmentTop10(start, end, query.getTaskId());
    }

    @Override
    public Map<String, Integer> vulSubmitTrend(TaskIdQuery query) {
        long start;
        long end;
        Map<String, Integer> last30DayMap;
        if (query.getTaskId() == null) {
            start = DateUtil.getBefore30Day();
            end = DateUtil.getToday235959();
            last30DayMap = DateUtil.getLast30DayMap();
        } else {
            TaskInfo taskInfo = taskInfoDao.queryById(query.getTaskId());
            start = taskInfo.getStartTime();
            end = taskInfo.getEndTime();
            last30DayMap = DateUtil.getDateRangeMap(start, end);
        }
        List<Map<String, Object>> data = vulInfoDao.getVulSubmitTrend(start, end, query.getTaskId());
        if (CollectionUtils.isNotEmpty(data)) {
            for (Map<String, Object> en : data) {
                last30DayMap.replace(en.get("days").toString(), ((Long)en.get("num")).intValue());
            }
        }
        return last30DayMap;
    }

    @Override
    public Map<String, Integer> vulRepairTrend(TaskIdQuery query) {
        long start;
        long end;
        Map<String, Integer> last30DayMap;
        if (query.getTaskId() == null) {
            start = DateUtil.getBefore30Day();
            end = DateUtil.getToday235959();
            last30DayMap = DateUtil.getLast30DayMap();
        } else {
            TaskInfo taskInfo = taskInfoDao.queryById(query.getTaskId());
            start = taskInfo.getStartTime();
            end = taskInfo.getEndTime();
            last30DayMap = DateUtil.getDateRangeMap(start, end);
        }
        List<Map<String, Object>> data = vulInfoDao.getVulRepairTrend(start, end, query.getTaskId());
        if (CollectionUtils.isNotEmpty(data)) {
            for (Map<String, Object> en : data) {
                last30DayMap.replace(en.get("days").toString(), ((Long)en.get("num")).intValue());
            }
        }
        return last30DayMap;
    }

    @Override
    public List<EventLevel> getEventLevel() {
        return userDao.getEventLevel();
    }

    @Override
    public List<UserResponse> getAllUser() {
        List<User> users = userDao.getALlUser();
        responseConverter.convert(users, UserResponse.class);
        List<UserResponse> reps = new ArrayList<>();
        for (User user : users) {
            UserResponse r = new UserResponse();
            BeanUtils.copyProperties(user, r);
            r.setBusinessId(user.getBusinessId().toString());
            reps.add(r);
        }
        return reps;
    }

    @Override
    public List<UserResponse> getNormalUserList() {
        List<User> users = userDao.getNormalUserList();
        List<UserResponse> reps = new ArrayList<>();
        for (User user : users) {
            UserResponse r = new UserResponse();
            BeanUtils.copyProperties(user, r);
            r.setBusinessId(user.getBusinessId().toString());
            reps.add(r);
        }
        return reps;
    }
}
