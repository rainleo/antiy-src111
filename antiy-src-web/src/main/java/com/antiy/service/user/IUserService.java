package com.antiy.service.user;

import com.antiy.base.PageResult;
import com.antiy.common.base.IBaseService;
import com.antiy.entity.user.Department;
import com.antiy.entity.user.User;
import com.antiy.entity.vul.EventLevel;
import com.antiy.query.user.ScoreQuery;
import com.antiy.query.user.UserQuery;
import com.antiy.request.user.BussinessIdRequest;
import com.antiy.request.user.UserRequest;
import com.antiy.response.user.UserResponse;
import com.antiy.response.vul.ScoreTop10;
import com.antiy.response.vul.VulIntegralInfoResponse;

import java.util.List;
import java.util.Map;


/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author wq
 * @since 2020-02-05
 */
public interface IUserService extends IBaseService<User> {

    /**
     * 保存
     *
     * @param request
     * @return
     */
    Long saveUser(UserRequest request) throws Exception;

    /**
     * 修改
     *
     * @param request
     * @return
     */
    String updateUser(UserRequest request) throws Exception;

    /**
     * 查询对象集合
     *
     * @param query
     * @return
     */
    List<UserResponse> queryListUser(UserQuery query) throws Exception;

    /**
     * 分页查询
     *
     * @param query
     * @return
     */
    PageResult<UserResponse> queryPageUser(UserQuery query) throws Exception;

    /**
     * 通过ID查询
     *
     * @param bussinessId
     * @return
     */
    UserResponse queryUserByBussinessId(Long businessId) throws Exception;

    /**
     * 通过ID删除
     *
     * @param baseRequest
     * @return
     */
    String deleteUserById(BussinessIdRequest baseRequest) throws Exception;

    /**
     * 管理员更新用户密码
     * @param businessId 业务主键
     * @param newPassword 新密码
     * @return void
     * @author wangqian
     * @date 2019/7/26
     */
    void updatePassword(Long businessId, String newPassword) throws Exception;

    /**
     * 用户自己修改密码
     * @param businessId 业务主键
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return void
     * @author wangqian
     * @date 2019/7/26
     */
    void updatePassword(Long businessId, String oldPassword, String newPassword) throws Exception;

    /**
     * 获取部门下拉
     * @return
     */
    List<Department> getDepartmentList();

    /**
     * 个人积分信息获取
     * @return
     */
    PageResult<VulIntegralInfoResponse> getScoreList(ScoreQuery query);

    public List<ScoreTop10> userScoreTop10();

    public List<ScoreTop10> departmentScoreTop10();

    public Map<String, Integer> vulSubmitTrend();

    public Map<String, Integer> vulRepairTrend();

    List<EventLevel> getEventLevel();

    /**
     * 获取全部用户
     * @return
     */
    List<UserResponse> getAllUser();

    /**
     * 获得个人总积分
     * @return
     */
    Integer getTotalScore();
}
