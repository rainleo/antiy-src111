package com.antiy.controller.sse;

import com.alibaba.fastjson.JSONObject;
import com.antiy.common.utils.LogUtils;
import com.antiy.response.vul.SseVulResponse;
import com.antiy.service.vul.IVulExamineInfoService;
import com.antiy.service.vul.IVulInfoService;
import com.antiy.util.LoginUserUtil;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器端实时推送技术之 SseEmitter 的用法 <p> 对接步骤: 1.start?clientId=111接口,浏览器会阻塞,建立连接 2.send?clientId=111接口,发送消息
 * 3.sendall?msg=111接口,广播发送消息 4.end?clientId=111接口结束某个请求，关闭连接 其中clientId代表请求的唯一标志，用户ID;
 *
 * @author ly
 */
@RestController
@RequestMapping("/api/v1/sse")
public class SseEmitterController {
    private Logger                   logger        = LogUtils.get(this.getClass());
    @Resource
    private LoginUserUtil            loginUserUtil;
    // 用于保存每个请求对应的 SseEmitter
    private static Map<Long, Result> sseEmitterMap = new ConcurrentHashMap<>();

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public SseEmitter testSseEmitter(HttpServletResponse response) {
        // 默认30秒超时,设置为0L则永不超时
        SseEmitter sseEmitter = new SseEmitter(0L);
        response.addHeader("X-Accel-Buffering", "no");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");
        response.setContentType("text/event-stream");
        response.setCharacterEncoding("UTF-8");
        Long clientId = loginUserUtil.getUser().getBusinessId();
        if (!sseEmitterMap.containsKey(clientId)) {
            sseEmitterMap.put(clientId, new Result(clientId, loginUserUtil.getUser().getRoleId(), sseEmitter));
        }
        return sseEmitter;
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public String completeSseEmitter() {
        Result result = sseEmitterMap.get(loginUserUtil.getUser().getBusinessId());
        if (result != null) {
            sseEmitterMap.remove(loginUserUtil.getUser().getBusinessId());
            result.sseEmitter.complete();
        }
        return "Succeed!";
    }

    /**
     * 向SseEmitter对象发送数据
     *
     * @return
     */
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public String setSseEmitter() {
        try {
            Result result = sseEmitterMap.get(loginUserUtil.getUser().getBusinessId());
            if (result != null && result.sseEmitter != null) {
                SseVulResponse response = new SseVulResponse();
                response.setNotice("测试结果");
                response.setCommitDate(System.currentTimeMillis());
                response.setVulName("sse测试漏洞");
                response.setVulId(12);
                result.sseEmitter.send(JSONObject.toJSONString(response));
            }
        } catch (IOException e) {
            logger.error("IOException!", e);
            return "error";
        }

        return "Succeed!";
    }

    /**
     *
     * @param response 漏洞id
     * @return
     */
    public static boolean sendall(SseVulResponse response) {
        boolean flag = true;
        for (Map.Entry<Long, Result> entry : sseEmitterMap.entrySet()) {
            try {
                // 向审核员发送通知
                if (entry.getValue().role == 3) {
                    entry.getValue().sseEmitter.send(JSONObject.toJSONString(response));
                }
            } catch (IOException e) {
                LogUtils.get().error("IOException!");
                flag = false;
            }
        }

        return flag;
    }

    /**
     *
     * @param clientId 提交漏洞用户id
     * @param response 通知消息
     * @return
     */
    public static boolean sendByClientID(String clientId, SseVulResponse response) {
        try {
            Result result = sseEmitterMap.get(clientId);
            if (result != null && result.sseEmitter != null) {
                result.sseEmitter.send(JSONObject.toJSONString(response));
            }
        } catch (IOException e) {
            LogUtils.get().error("IOException!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private class Result {
        private Long       clientId;
        private Integer    role;
        private SseEmitter sseEmitter;

        public Result(Long clientId, Integer role, SseEmitter sseEmitter) {
            this.clientId = clientId;
            this.role = role;
            this.sseEmitter = sseEmitter;
        }
    }
}