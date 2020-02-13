package com.antiy.controller.sse;

import com.antiy.common.utils.LogUtils;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 服务器端实时推送技术之 SseEmitter 的用法
 * <p>
 * 对接步骤:
 * 1.start?clientId=111接口,浏览器会阻塞,建立连接
 * 2.send?clientId=111接口,发送消息
 * 3.sendall?msg=111接口,广播发送消息
 * 4.end?clientId=111接口结束某个请求，关闭连接
 * 其中clientId代表请求的唯一标志，用户ID;
 *
 * @author ly
 */
@RestController
@RequestMapping("/sse")
public class SseEmitterController {
    private Logger logger = LogUtils.get(this.getClass());

    // 用于保存每个请求对应的 SseEmitter
    private static Map<String, Result> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 返回SseEmitter对象
     *
     * @param clientId
     * @return
     */
    @RequestMapping("/start")
    public SseEmitter testSseEmitter(String clientId) {
        // 默认30秒超时,设置为0L则永不超时
        SseEmitter sseEmitter = new SseEmitter(0L);
        sseEmitterMap.put(clientId, new Result(clientId, System.currentTimeMillis(), sseEmitter));
        return sseEmitter;
    }

    /**
     * 向SseEmitter对象发送数据
     *
     * @param clientId 客户ID
     * @return
     */
    @RequestMapping("/send")
    public String setSseEmitter(String clientId) {
        try {
            Result result = sseEmitterMap.get(clientId);
            if (result != null && result.sseEmitter != null) {
                long timestamp = System.currentTimeMillis();
                result.sseEmitter.send(timestamp);
            }
        } catch (IOException e) {
            logger.error("IOException!");
            return "error";
        }

        return "Succeed!";
    }

    /**
     * 将SseEmitter对象设置成完成
     *
     * @param clientId
     * @return
     */
    @RequestMapping("/end")
    public String completeSseEmitter(String clientId) {
        Result result = sseEmitterMap.get(clientId);
        if (result != null) {
            sseEmitterMap.remove(clientId);
            result.sseEmitter.complete();
        }
        return "Succeed!";
    }


    /**
     * 向所有SseEmitter对象发送数据
     *
     * @param msg
     * @return
     */
    public static boolean sendall(String msg) {
        boolean flag = true;
        for (Map.Entry<String, Result> entry : sseEmitterMap.entrySet()) {
            try {
                entry.getValue().sseEmitter.send(msg);
            } catch (IOException e) {
                LogUtils.get().error("IOException!");
                flag = false;
            }
        }

        return flag;
    }


    /**
     * 向指定SseEmitter对象发送数据
     *
     * @param clientId 客户ID
     * @param msg 消息
     * @return 成功失败
     */
    public static boolean sendByClientID(String clientId, String msg) {
        try {
            Result result = sseEmitterMap.get(clientId);
            if (result != null && result.sseEmitter != null) {
                result.sseEmitter.send(msg);
            }
        } catch (IOException e) {
            LogUtils.get().error("IOException!");
            return false;
        }
        return true;
    }

    private class Result {
        public String clientId;
        public long timestamp;
        public SseEmitter sseEmitter;

        public Result(String clientId, long timestamp, SseEmitter sseEmitter) {
            this.clientId = clientId;
            this.timestamp = timestamp;
            this.sseEmitter = sseEmitter;
        }
    }
}