package com.antiy.service.vul.impl;

import com.antiy.base.BaseConverter;
import com.antiy.base.PageResult;
import com.antiy.common.utils.LogUtils;
import com.antiy.dao.vul.TaskInfoDao;
import com.antiy.entity.user.LoginUser;
import com.antiy.entity.vul.TaskInfo;
import com.antiy.query.vul.TaskInfoQuery;
import com.antiy.request.vul.TaskInfoRequest;
import com.antiy.service.vul.ITaskInfoService;
import com.antiy.util.BusinessExceptionUtils;
import com.antiy.util.LoginUserUtil;
import org.apache.commons.compress.utils.Lists;
import org.slf4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p> 服务实现类 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
@Service
public class TaskInfoServiceImpl implements ITaskInfoService {

    private Logger                           logger        = LogUtils.get(this.getClass());
    @Resource
    private LoginUserUtil                    loginUserUtil;
    @Resource
    private TaskInfoDao                      taskInfoDao;

    BaseConverter<TaskInfoRequest, TaskInfo> baseConverter = new BaseConverter();

    @Override
    public void saveSingle(TaskInfoRequest taskInfoRequest) {
        TaskInfo taskInfo = baseConverter.convert(taskInfoRequest, TaskInfo.class);
        taskInfo.setTaskNo(getTaskNo(taskInfoRequest.getTaskType()));
        taskInfo.setCreateUser(loginUserUtil.getUser().getBusinessId());
        taskInfo.setGmtCreate(System.currentTimeMillis());
        taskInfo.setStatus(1);
        try {
            taskInfoDao.saveSingle(taskInfo);
        } catch (DuplicateKeyException e) {
            BusinessExceptionUtils.isTrue(false, "已存在该任务!");
        }
    }

    @Override
    public Integer updateSingle(TaskInfoRequest taskInfoRequest) {
        TaskInfo taskInfo = baseConverter.convert(taskInfoRequest, TaskInfo.class);
        taskInfo.setModifyUser(loginUserUtil.getUser().getBusinessId());
        taskInfo.setGmtModify(System.currentTimeMillis());
        Integer count = 0;
        try {
            count = taskInfoDao.updateSingle(taskInfo);
        } catch (DuplicateKeyException e) {
            BusinessExceptionUtils.isTrue(false, "已存在该任务!");
        }
        return count;
    }

    @Override
    public void deleteSingle(Integer id) {

        TaskInfo taskInfo = taskInfoDao.queryById(id);
        // 任务已经过期，目前暂定可以过期删除
        if (taskInfo.getEndTime() < System.currentTimeMillis()) {
            taskInfo.setGmtModify(System.currentTimeMillis());
            taskInfo.setModifyUser(loginUserUtil.getUser().getBusinessId());
            taskInfoDao.deleteSingle(taskInfo);
        } else {
            BusinessExceptionUtils.isTrue(false, "任务未到期不能删除任务");
        }
    }

    @Override
    public PageResult<TaskInfo> queryList(TaskInfoQuery taskInfoQuery) {
        Integer count = taskInfoDao.queryCount(taskInfoQuery);
        if (count <= 0) {
            return new PageResult<>(taskInfoQuery.getPageSize(), count, taskInfoQuery.getCurrentPage(),
                Lists.newArrayList());
        }
        List<TaskInfo> taskInfoList = taskInfoDao.queryList(taskInfoQuery);
        return new PageResult<>(taskInfoQuery.getPageSize(), count, taskInfoQuery.getCurrentPage(), taskInfoList);
    }

    private static String getTaskNo(Integer type) {
        String t = type == 1 ? "SL" : "PL";
        return String.join("-", String.valueOf(System.currentTimeMillis()), t);
    }
}
