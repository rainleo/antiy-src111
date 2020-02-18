package com.antiy.config;

import com.alibaba.fastjson.JSONObject;
import com.antiy.base.ActionResponse;
import com.antiy.base.RespBasicCode;
import com.antiy.controller.sse.SseEmitterController;
import com.antiy.response.vul.SseVulResponse;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.TokenStoreUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Configuration      // 1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class SaticScheduleTask {
    @Resource
    private LoginUserUtil loginUserUtil;

    // 3.添加定时任务
    @Scheduled(cron = "0/5 * * * * ?")
    // 或直接指定时间间隔，例如：5秒
    // @Scheduled(fixedRate=5000)
    private void configureTasks() {
        SseEmitterController.sseEmitterMap.keySet().forEach(k -> {
            if (TokenStoreUtil.checkTokenIsValid(k)) {
                SseEmitterController.Result result = SseEmitterController.sseEmitterMap.get(k);
                if (result != null && result.getSseEmitter() != null) {
                    SseVulResponse response = new SseVulResponse();
                    response.setNotice("测试结果");
                    response.setCommitDate(System.currentTimeMillis());
                    response.setVulName("sse测试漏洞");
                    response.setVulId(12);
                    SseEmitter.SseEventBuilder builder = SseEmitter.event().id(UUID.randomUUID().toString())
                        .data(JSONObject.toJSONString(response), MediaType.APPLICATION_JSON);
                    try {
                        result.getSseEmitter().send(builder);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}