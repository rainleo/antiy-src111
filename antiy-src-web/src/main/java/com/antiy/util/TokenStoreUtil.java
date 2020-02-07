package com.antiy.util;

import com.antiy.entity.user.LoginUser;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @program antiy-src-parent
 * @description 存储token和用户信息
 * @author wangqian
 * created on 2020-02-06
 * @version  1.0.0
 */
public class TokenStoreUtil {
    public final static ConcurrentHashMap<String, UserData> map = new ConcurrentHashMap<>();
    public static void put(String token, Long expired, LoginUser userinfo) {
        map.forEach((tk, user) -> {
            Long curTime = System.currentTimeMillis();
            if (curTime > user.getExpired()) {
                map.remove(tk);
            }
        });
       UserData user = new UserData(expired, userinfo);
       map.put(token, user);
    }

    public static LoginUser get(String token) {
        UserData user = map.get(token);
        return user.getUserinfo();
    }
    /** 通过用户id获取token **/
    public static String get(Long userId) {
        for (Map.Entry<String, UserData> user : map.entrySet()) {
            if (userId.equals(user.getValue().getUserinfo().getBusinessId())) {
                return user.getKey();
            }
        }
        return null;
    }

    public static void relongExpired(String token, Long expired) {
        UserData user = map.get(token);
        user.setExpired(expired);
    }

    /**
     * 是否存在用户已登录
     * @param userId
     */
    public static Boolean existToken(Long userId) {
       for (Map.Entry<String, UserData> user : map.entrySet()) {
            if (userId.equals(user.getValue().getUserinfo().getBusinessId())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 移除在线用户
     * @param token
     */
    public static void removeToken(String token) {
       map.remove(token);
    }


    private static class UserData {

        public UserData(Long expired, LoginUser userinfo) {
            this.expired = expired;
            this.userinfo = userinfo;
        }

        /**
         * token过期时间
         */
        private Long expired;
        /**
         * token对应的用户信息
         */
        private LoginUser userinfo;

        public Long getExpired() {
            return expired;
        }

        public void setExpired(Long expired) {
            this.expired = expired;
        }

        public LoginUser getUserinfo() {
            return userinfo;
        }

        public void setUserinfo(LoginUser userinfo) {
            this.userinfo = userinfo;
        }
    }
}
