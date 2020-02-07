package com.antiy.consts;

/**
 * @author zhouchengpei
 * date   2019/11/18 11:14
 * description .
 */
public class LogAnalysis {
    /**
     * 升序排序
     */
    public static final String SORT_ASC = "asc";


    /**
     * 危害等级     severity            4危急 3高危 2中危 1低危
     */
    public static final String SEVERITY = "severity";

    /**
     * 自定义
     */
    public static final Integer CUSTOM = 5;

    /**
     * 危急
     */
    public static final Integer SEVERITY_CRITICAL = 4;
    /**
     * 高危
     */
    public static final Integer SEVERITY_HIGH_RISK = 3;
    /**
     * 中危
     */
    public static final Integer SEVERITY_MIDDLE_RISK = 2;
    /**
     * 低危
     */
    public static final Integer SEVERITY_LOW_RISK = 1;
    /**
     * 其他
     */
    public static final Integer OTHER = 0;






    /**
     * 威胁类型     attackType    见复选框映射.txt
     */
    public static final String THREATEN_TYPE = "threatenType";


    /**
     * 攻击结果     attackResult           0企图 1成功 2失陷 3失败
     */
    public static final String ATTACK_RESULT = "attackResult";

    /**
     * DNS 1 是 0 否
     */
    public static final String WHITE_LIST_TYPE = "whiteListType";

    /**
     * whiteList 1 是 0 否
     */
    public static final String WHITE_LIST = "whiteList";

    /**
     * 企图
     */
    public static final String RESULT_ATTEMPT = "0";
    /**
     * 成功
     */
    public static final String RESULT_SUCCESS = "1";
    /**
     * 失陷
     */
    public static final String RESULT_FALL = "2";
    /**
     * 失败
     */
    public static final String RESULT_FAIL = "3";


    /**
     * 白名单      whiteListType     2网络爬虫 3域名服务器 1CDN 0不是白名单 4其他
     */
    public static final String WHITELIST_TYPE = "whiteListType";
    /**
     * 网络爬虫
     */
    public static final String WHITELIST_TYPE_INTERNET_WORM = "2";
    /**
     * 域名服务器
     */
    public static final String WHITELIST_TYPE_DOMAIN_SERVER = "3";
    /**
     * CDN
     */
    public static final String WHITELIST_TYPE_CDN = "1";
    /**
     * 不是白名单
     */
    public static final String WHITELIST_TYPE_NO_WHITELIST = "0";
    /**
     *
     */
    public static final String WHITELIST_TYPE_OTHER = "4";


    /**
     * 虚警黑白名单 blackWhiteList    0虚警黑名单 1虚警白名单
     */
    public static final String BLACKWHITELIST = "blackWhiteListMsg";
    /**
     * 虚警黑名单
     */
    public static final Integer BLACKWHITELIST_FALSE_ALARM_BLACKLIST = 0;
    /**
     * 虚警白名单
     */
    public static final Integer BLACKWHITELIST_FALSE_ALARM_WHITELIST = 1;

}
