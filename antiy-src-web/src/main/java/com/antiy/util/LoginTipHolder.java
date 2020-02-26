package com.antiy.util;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @program kbms-parent
 * @description 用户强制退出提示语
 * @author wangqian
 * created on 2019-07-31
 * @version  1.0.0
 */
public class LoginTipHolder {

    private final static ConcurrentHashMap<String, String> USER_TIP = new ConcurrentHashMap<>();

    /**
    * 通过用户编号获取提示信息
    * @param token 用户编号
    * @return java.lang.String
    * @author wangqian
    * @date 2019/7/31
    */
    public static String getTip(String token) {
        String tip = USER_TIP.get(token);
        USER_TIP.remove(token);
        return tip;
    }

    /** 
    * 移除某个用户的提示信息 
    * @param token 用户编号
    * @return void 
    * @author wangqian
    * @date 2019/7/31 
    */ 
    public static boolean removeTip(String token) {
        USER_TIP.remove(token);
        return true;
    }

    /** 
    * 移除全部消息
    * @param
    * @return void 
    * @author wangqian
    * @date 2019/7/31 
    */ 
    public static void removeAllTips() {
        USER_TIP.clear();
    }

    /**
    * 放提示信息
    * @param token 用户编号
    * @param  tip 提示语
    * @return void
    * @author wangqian
    * @date 2019/7/31
    */
    public static void putTip(String token, String tip) {
        USER_TIP.put(token, tip);
    }

    public static boolean containsKey(String key) {
         return USER_TIP.containsKey(key);
    }
}
