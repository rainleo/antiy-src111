package com.antiy.consts;

/**
 * @author liuyu
 * @date
 *
 */

public final class Constants {
    /**
     * 每页最大条数
     */
    public final static int MAX_PAGESIZE = 100;

    /**
     * 默认分页大小
     */
    public final static int DEFAULT_PAGESIZE = 10;

    /**
     * 默认分页为第一页
     */
    public final static int DEFAULT_PAGE = 1;

    /**
     * 默认排序字段
     */
    public final static String DEFAULT_SORTNAME = "gmt_create";

    /**
     * 默认排序方向
     */
    public final static String DEFAULT_SORTORDER = "desc";

    /**
     * 默认父类ID
     */
    public static final int DEFAULT_PARENT_ID = 0;
    /**
     * 漏洞上报告警主题
     */
    public static final String ALARM_FROM_VUL_TOPIC="queue.csos.vul.alarm";
    /**
     * 系统监测上报告警主题
     */
    public static final String ALARM_FROM_SYS_MONITOR_TOPIC="queue.csos.alarm.system.monitor";
    /**
     * 安全设备性能监测上报告警主题
     */
    public static final String ALARM_FROM_SAFETY_PERFORMANCE_TOPIC = "queue.csos.alarm.safety.performance";
    /**
     * 威胁事件上报告警主题
     */
    public static final String THREAT_EVENT_ALARM_TOPIC = "queue.csos.alarm.threat.event";

    /**
     * 重点目标 key
     */
    public static final String REDIS_KEY_OBJECT_PREFIX = "qwjt:keyobject:";

    /**
     * 重点目标 Rediskey,用于本地缓存加载
     */
    public static final String REDIS_KEY_OBJECT_LIST = "keyobject:list";

    /**
     * 虚假告警过滤
     */
    public static final String FALSE_ALARM_FILTER = "false_alarm_filter";

    /**
     * 虚假告警过滤-黑名单
     */
    public static final Integer BLACK_FALSE_ALARM = 1;

    /**
     * 虚假告警过滤-白名单
     */
    public static final Integer WHITE_FALSE_ALARM = 0;

    /**
     * 是虚警
     */
    public static final Integer FALSE_ALARM = 1;
    /**
     * 不是虚警
     */
    public static final Integer NOT_FALSE_ALARM = 0;

    /**
     * 虚假告警过滤-源ip
     */
    public static final Integer SOURCE_IP = 1;

    /**
     * 虚假告警过滤-目的ip
     */
    public static final Integer DESC_IP = 0;
}