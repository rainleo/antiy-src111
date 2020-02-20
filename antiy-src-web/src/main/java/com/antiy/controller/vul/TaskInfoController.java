package com.antiy.controller.vul;

import com.antiy.base.ActionResponse;
import com.antiy.base.PageResult;
import com.antiy.exception.BusinessException;
import com.antiy.query.vul.TaskInfoQuery;
import com.antiy.request.BaseRequest;
import com.antiy.request.vul.TaskInfoRequest;
import com.antiy.response.vul.TaskInfoResponse;
import com.antiy.service.vul.ITaskInfoService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author lvliang
 * @since 2020-02-06
 */
@Api(value = "TaskInfo", description = "任务模块")
@RestController
@RequestMapping("/api/v1/taskinfo")
public class TaskInfoController {

    @Resource
    public ITaskInfoService iTaskInfoService;

    /**
     * 保存
     *
     * @param taskInfoRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存任务", notes = "传入实体对象信息")
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse saveSingle(@ApiParam(value = "taskInfo") @RequestBody TaskInfoRequest taskInfoRequest) throws Exception {
        if (taskInfoRequest.getStartTime() >= taskInfoRequest.getEndTime()) {
            throw new BusinessException("结束日期必须大于开始日期");
        }
        iTaskInfoService.saveSingle(taskInfoRequest);
        return ActionResponse.success();
    }

    /**
     * 修改
     *
     * @param taskInfoRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改任务", notes = "传入实体对象信息")
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse updateSingle(@ApiParam(value = "taskInfo") @RequestBody TaskInfoRequest taskInfoRequest) throws Exception {
        if (taskInfoRequest.getStartTime() >= taskInfoRequest.getEndTime()) {
            throw new BusinessException("结束日期必须大于开始日期");
        }
        return ActionResponse.success(iTaskInfoService.updateSingle(taskInfoRequest));
    }

    /**
     * 删除
     *
     * @param baseRequest
     * @return actionResponse
     */
    @ApiOperation(value = "删除任务", notes = "传入实体对象信息")
    @RequestMapping(value = "/delete/single", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse deleteSingle(@ApiParam(value = "taskInfo") @RequestBody BaseRequest baseRequest) throws Exception {
        iTaskInfoService.deleteSingle(baseRequest.getId());
        return ActionResponse.success();
    }

    /**
     * 查询
     *
     * @param taskInfoQuery
     * @return actionResponse
     */
    @ApiOperation(value = "查询任务", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/list", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse<PageResult<TaskInfoResponse>> queryList(@ApiParam(value = "taskInfo") @RequestBody TaskInfoQuery taskInfoQuery) throws Exception {
        return ActionResponse.success(iTaskInfoService.queryList(taskInfoQuery));
    }

}
