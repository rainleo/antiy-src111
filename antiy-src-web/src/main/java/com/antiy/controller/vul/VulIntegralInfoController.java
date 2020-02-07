package com.antiy.controller.vul;

import com.antiy.base.ActionResponse;
import com.antiy.request.vul.VulIntegralInfoRequest;
import com.antiy.service.vul.IVulIntegralInfoService;
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
@Api(value = "VulIntegralInfo", description = "")
@RestController
@RequestMapping("/v1/vulintegralinfo")
public class VulIntegralInfoController {

    @Resource
    public IVulIntegralInfoService iVulIntegralInfoService;

    /**
     * 保存
     *
     * @param vulIntegralInfoRequest
     * @return actionResponse
     */
    @ApiOperation(value = "保存接口", notes = "传入实体对象信息")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Integer.class),
    })
    @RequestMapping(value = "/save/single", method = RequestMethod.POST)
    public ActionResponse saveSingle(@ApiParam(value = "vulIntegralInfo") @RequestBody VulIntegralInfoRequest vulIntegralInfoRequest) throws Exception {
        return ActionResponse.success();
    }


}

