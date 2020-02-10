package com.antiy.controller.vul;

import com.antiy.base.ActionResponse;
import com.antiy.request.vul.VulExamineInfoRequest;
import com.antiy.service.vul.IVulExamineInfoService;
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
@Api(value = "VulExamineInfo", description = "")
@RestController
@RequestMapping("/v1/vulexamineinfo")
public class VulExamineInfoController {

    @Resource
    public IVulExamineInfoService iVulExamineInfoService;

    /**
     * 保存审批信息
     *
     * @param vulExamineInfoRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "vulExamineInfo") @RequestBody VulExamineInfoRequest vulExamineInfoRequest) throws Exception {
        iVulExamineInfoService.saveSingle(vulExamineInfoRequest);
        return ActionResponse.success();
    }

}

