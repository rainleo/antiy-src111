package com.antiy.controller.user;

import com.antiy.base.ActionResponse;
import com.antiy.enums.user.VulLevelEnum;
import com.antiy.enums.user.VulTypeEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program antiy-src-parent
 * @description 
 * @author wangqian
 * created on 2020-02-13
 * @version  1.0.0
 */
@RestController
@Api(description = "码值管理")
@RequestMapping("/api/v1/code")
public class CodeController {

    @ApiOperation("漏洞等级")
    @PostMapping("/vulLevel")
    public ActionResponse vulLevel() {
        VulLevelEnum[] values = VulLevelEnum.values();
        List<Map<String, Object>> result = new ArrayList<>();
        for (VulLevelEnum value : values) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", value.getCode());
            map.put("text", value.getMsg());
            result.add(map);
        }
        return ActionResponse.success(result);
    }

    @ApiOperation("漏洞类型")
    @PostMapping("/vulType")
    public ActionResponse vulType() {
        VulTypeEnum[] values = VulTypeEnum.values();
        List<Map<String, Object>> result = new ArrayList<>();
        for (VulTypeEnum value : values) {
            Map<String, Object> map = new HashMap<>();
            map.put("code", value.getCode());
            map.put("text", value.getMsg());
            result.add(map);
        }
        return ActionResponse.success(result);
    }
}
