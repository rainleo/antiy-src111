package com.antiy.controller.sse;

import com.alibaba.fastjson.JSONObject;
import com.antiy.base.ActionResponse;
import com.antiy.base.RespBasicCode;
import com.antiy.common.utils.LogUtils;
import com.antiy.response.vul.SseVulResponse;
import com.antiy.service.vul.IVulExamineInfoService;
import com.antiy.service.vul.IVulInfoService;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.MapUtil;
import com.antiy.util.TokenStoreUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器端实时推送技术之 SseEmitter 的用法 <p> 对接步骤: 1.start?clientId=111接口,浏览器会阻塞,建立连接 2.send?clientId=111接口,发送消息
 * 3.sendall?msg=111接口,广播发送消息 4.end?clientId=111接口结束某个请求，关闭连接 其中clientId代表请求的唯一标志，用户ID;
 *
 * @author ly
 */
@RestController
@RequestMapping("/api/v1/sse")
@CrossOrigin
public class SseEmitterController {
    private Logger                    logger        = LogUtils.get(this.getClass());
    @Resource
    private LoginUserUtil             loginUserUtil;
    // 用于保存每个请求对应的 SseEmitter,key为token
    public static Map<String, Result> sseEmitterMap = new ConcurrentHashMap<>();

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public SseEmitter start(HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/event-stream");
        /*response.addHeader("X-Accel-Buffering", "no");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control", "no-cache");*/
        // 当前登录用户的id
        Long clientId = loginUserUtil.getUser().getBusinessId();
        // 当前登录用户的token
        String token = TokenStoreUtil.get(clientId);
        if (StringUtils.isBlank(token)) {
            return null;
        }
        // 移除过期用户的sseEmitter连接
        if (MapUtils.isNotEmpty(sseEmitterMap)) {
            sseEmitterMap.keySet().stream().forEach(t -> {
                if (!TokenStoreUtil.checkTokenIsValid(t)) {
                    Result result = sseEmitterMap.get(t);
                    if (result != null) {
                        sseEmitterMap.remove(t);
                        result.sseEmitter.complete();
                    }
                }
            });
        }
        // 当前是否存在与用户绑定的sseEmitter对象
        if (!sseEmitterMap.containsKey(token)) {
            // 默认30秒超时,设置为0L则永不超时
            SseEmitter sseEmitter = new SseEmitter(0L);
            sseEmitterMap.put(token, new Result(token, clientId, loginUserUtil.getUser().getRoleId(), sseEmitter));
            return sseEmitter;
        } else {
            return sseEmitterMap.get(token).getSseEmitter();
        }
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public ActionResponse completeSseEmitter() {
        String token = TokenStoreUtil.get(loginUserUtil.getUser().getBusinessId());
        if (StringUtils.isNotBlank(token)) {
            Result result = sseEmitterMap.get(token);
            if (result != null) {
                sseEmitterMap.remove(token);
                result.sseEmitter.complete();
            }
        }
        return ActionResponse.success();
    }

    /**
     *
     * @param response 漏洞id
     * @return
     */
    public static boolean sendall(SseVulResponse response) {
        boolean flag = true;
        SseEmitter.SseEventBuilder builder = SseEmitter.event().id(UUID.randomUUID().toString())
            .data(JSONObject.toJSONString(response), MediaType.APPLICATION_JSON);
        for (Map.Entry<String, Result> entry : sseEmitterMap.entrySet()) {
            try {
                // 向审核员发送通知
                if (entry.getValue() != null && entry.getValue().role == 3) {
                    entry.getValue().sseEmitter.send(builder);
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
     * @param userId 提交漏洞用户id
     * @param response 通知消息
     * @return
     */
    public static boolean sendByClientID(Long userId, SseVulResponse response) {
        try {
            String token = TokenStoreUtil.get(userId);
            if (StringUtils.isNotBlank(token)) {
                Result result = sseEmitterMap.get(token);
                if (result != null && result.sseEmitter != null) {
                    SseEmitter.SseEventBuilder builder = SseEmitter.event().id(UUID.randomUUID().toString())
                        .data(JSONObject.toJSONString(response), MediaType.APPLICATION_JSON);
                    result.sseEmitter.send(builder);
                }
            }
        } catch (IOException e) {
            LogUtils.get().error("IOException!");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public class Result {
        private String     token;
        private Long       clientId;
        private Integer    role;
        private SseEmitter sseEmitter;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public Long getClientId() {
            return clientId;
        }

        public void setClientId(Long clientId) {
            this.clientId = clientId;
        }

        public Integer getRole() {
            return role;
        }

        public void setRole(Integer role) {
            this.role = role;
        }

        public SseEmitter getSseEmitter() {
            return sseEmitter;
        }

        public void setSseEmitter(SseEmitter sseEmitter) {
            this.sseEmitter = sseEmitter;
        }

        public Result(String token, Long clientId, Integer role, SseEmitter sseEmitter) {
            this.token = token;
            this.clientId = clientId;
            this.role = role;
            this.sseEmitter = sseEmitter;
        }
    }
}