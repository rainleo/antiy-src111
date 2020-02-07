package com.antiy.service.vul;

import com.antiy.base.PageResult;
import com.antiy.entity.vul.TaskInfo;
import com.antiy.query.vul.TaskInfoQuery;
import com.antiy.request.vul.TaskInfoRequest;

/**
 * <p> 服务类 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface ITaskInfoService {

    /**
     * 保存任务
     * @param taskInfoRequest
     */
    void saveSingle(TaskInfoRequest taskInfoRequest);

    /**
     * 修改任务
     * @param taskInfoRequest
     * @return
     */
    Integer updateSingle(TaskInfoRequest taskInfoRequest);

    /**
     * 删除任务
     * @param id
     * @return
     */
    void deleteSingle(Integer id);

    /**
     * 列表查询
     * @param taskInfoQuery
     * @return
     */
    PageResult<TaskInfo> queryList(TaskInfoQuery taskInfoQuery);
}
