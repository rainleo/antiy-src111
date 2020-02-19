package com.antiy.dao.vul;

import com.antiy.entity.vul.TaskInfo;
import com.antiy.query.vul.TaskInfoQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p> Mapper 接口 </p>
 *
 * @author lvliang
 * @since 2020-02-06
 */
public interface TaskInfoDao {
    /**
     * 保存任务信息
     * @param taskInfo
     */
    void saveSingle(TaskInfo taskInfo);

    /**
     * 修改任务信息
     * @param taskInfo
     * @return
     */
    Integer updateSingle(TaskInfo taskInfo);

    TaskInfo queryById(@Param("id") Integer id);

    void deleteSingle(TaskInfo taskInfo);

    Integer queryCount(TaskInfoQuery taskInfoQuery);

    List<TaskInfo> queryList(TaskInfoQuery taskInfoQuery);

    Integer checkRepeatTask(@Param("taskName") String taskName, @Param("taskType") Integer taskType,
                            @Param("time") long time);
}
