package com.antiy.controller.vul;

import com.antiy.base.ActionResponse;
import com.antiy.query.vul.VulInfoQuery;
import com.antiy.request.vul.VulInfoRequest;
import com.antiy.service.vul.IVulInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author lvliang
 * @since 2020-02-06
 */
@Api(value = "VulInfo", description = "漏洞模块")
@RestController
@RequestMapping("/v1/vulinfo")
public class VulInfoController {

    @Resource
    public IVulInfoService iVulInfoService;

    /**
     * 保存漏洞信息
     *
     * @param vulInfoRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存漏洞信息", notes = "传入实体对象信息")
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "vulInfo") @RequestBody VulInfoRequest vulInfoRequest) throws Exception {
        iVulInfoService.saveSingle(vulInfoRequest);
        return ActionResponse.success();
    }

    /**
     *  漏洞列表查询
     *
     * @param vulInfoQuery
     * @return actionResponse
     */
    @ApiOperation(value = "漏洞列表查询", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/list", method = RequestMethod.POST)
    public ActionResponse queryList(@ApiParam(value = "vulInfo") @RequestBody VulInfoQuery vulInfoQuery) throws Exception {
        return ActionResponse.success(iVulInfoService.queryList(vulInfoQuery));
    }

    /**
     * 修改漏洞信息
     *
     * @param vulInfoRequest
     * @return actionResponse
     */
    @ApiOperation(value = "修改漏洞信息", notes = "传入实体对象信息")
    @RequestMapping(value = "/update/single", method = RequestMethod.POST)
    public ActionResponse updateSingle(@ApiParam(value = "vulInfo") @RequestBody VulInfoRequest vulInfoRequest) throws Exception {
        return ActionResponse.success(iVulInfoService.updateSingle(vulInfoRequest));
    }

    /**
     * 漏洞详情
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "漏洞详情", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/detail", method = RequestMethod.POST)
    public ActionResponse queryDetail(@ApiParam(value = "vulInfo") @RequestBody Integer id) throws Exception {
        return ActionResponse.success(iVulInfoService.queryDetail(id));
    }
    /**
     * 漏洞审批历史
     *
     * @param id
     * @return actionResponse
     */
    @ApiOperation(value = "漏洞审批历史", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/examineHistory", method = RequestMethod.POST)
    public ActionResponse queryExamineHistory(@ApiParam(value = "vulInfo") @RequestBody Integer id) throws Exception {
        return ActionResponse.success(iVulInfoService.queryExamineHistory(id));
    }

}

