package com.antiy.controller.vul;

import com.antiy.base.ActionResponse;
import com.antiy.query.vul.TaskInfoQuery;
import com.antiy.request.vul.TaskInfoRequest;
import com.antiy.service.vul.ITaskInfoService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lvliang
 * @since 2020-02-06
 */
@Api(value = "TaskInfo", description = "任务模块")
@RestController
@RequestMapping("/v1/taskinfo")
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
    public ActionResponse saveSingle(@ApiParam(value = "taskInfo") @RequestBody TaskInfoRequest taskInfoRequest) throws Exception {
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
    public ActionResponse updateSingle(@ApiParam(value = "taskInfo") @RequestBody TaskInfoRequest taskInfoRequest) throws Exception {
        return ActionResponse.success(iTaskInfoService.updateSingle(taskInfoRequest));
    }

    /**
     * 删除
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "删除任务", notes = "传入实体对象信息")
    @RequestMapping(value = "/delete/single", method = RequestMethod.POST)
    public ActionResponse deleteSingle(@ApiParam(value = "taskInfo") @RequestBody Integer id) throws Exception {
        iTaskInfoService.deleteSingle(id);
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
    public ActionResponse queryList(@ApiParam(value = "taskInfo") @RequestBody TaskInfoQuery taskInfoQuery) throws Exception {
        return ActionResponse.success(iTaskInfoService.queryList(taskInfoQuery));
    }

}
