package com.antiy.controller.vul;

import com.antiy.base.ActionResponse;
import com.antiy.base.PageResult;
import com.antiy.query.vul.VulInfoQuery;
import com.antiy.request.BaseRequest;
import com.antiy.request.vul.VulInfoRequest;
import com.antiy.response.vul.VulExamineInfoResponse;
import com.antiy.response.vul.VulInfoResponse;
import com.antiy.service.vul.IVulInfoService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author lvliang
 * @since 2020-02-06
 */
@Api(value = "VulInfo", description = "漏洞模块")
@RestController
@RequestMapping("/api/v1/vulinfo")
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
    @ResponseBody
    public ActionResponse saveSingle(@ApiParam(value = "vulInfo") @RequestBody VulInfoRequest vulInfoRequest) throws Exception {
        iVulInfoService.saveSingle(vulInfoRequest);
        return ActionResponse.success();
    }

    /**
     * 漏洞列表查询
     *
     * @param vulInfoQuery
     * @return actionResponse
     */
    @ApiOperation(value = "漏洞列表查询", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/list", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse<PageResult<VulInfoResponse>> queryList(@ApiParam(value = "vulInfo") @RequestBody VulInfoQuery vulInfoQuery) throws Exception {
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
    @ResponseBody
    public ActionResponse updateSingle(@ApiParam(value = "vulInfo") @RequestBody VulInfoRequest vulInfoRequest) throws Exception {
        return ActionResponse.success(iVulInfoService.updateSingle(vulInfoRequest));
    }

    /**
     * 漏洞详情
     *
     * @param baseRequest
     * @return actionResponse
     */
    @ApiOperation(value = "漏洞详情", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/detail", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse<VulInfoResponse> queryDetail(@ApiParam(value = "vulInfo") @RequestBody BaseRequest baseRequest) throws Exception {
        return ActionResponse.success(iVulInfoService.queryDetail(baseRequest.getId()));
    }

    /**
     * 漏洞审批历史
     *
     * @param baseRequest
     * @return actionResponse
     */
    @ApiOperation(value = "漏洞审批历史", notes = "传入实体对象信息")
    @RequestMapping(value = "/query/examineHistory", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse<List<VulExamineInfoResponse>> queryExamineHistory(@ApiParam(value = "vulInfo") @RequestBody BaseRequest baseRequest) throws Exception {
        return ActionResponse.success(iVulInfoService.queryExamineHistory(baseRequest.getId()));
    }

    /**
     * 导出
     *
     * @param vulInfoQuery 封装对象
     * @return actionResponse
     */
    @ApiOperation(value = "根据条件导出硬件信息", notes = "主键封装对象")
    @RequestMapping(value = "/export/file", method = RequestMethod.GET)
    public void export(@ApiParam(value = "query") VulInfoQuery vulInfoQuery, HttpServletResponse response,
                       HttpServletRequest request) throws Exception {
        iVulInfoService.exportData(vulInfoQuery, response, request);
    }

}
