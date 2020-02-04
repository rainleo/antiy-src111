package com.antiy.util.code;

import com.antiy.common.utils.LogUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 验证码校验
 * @author wangyajing
 */
public class ValidateImageCode {
    private static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";

    /**
     * 判断验证码是否正确
     * @param request
     * @param imageCode
     * @return
     */
    public static boolean validate(HttpServletRequest request, String imageCode){
        Logger log = LogUtils.get(ValidateImageCode.class);
        HttpSession session = request.getSession();
        //从session中获取图片验证码
        Map<String,String> sessionMap = (Map<String, String>) session.getAttribute(SESSION_KEY);
        if(null != sessionMap && sessionMap.size() > 0){
            String codeInSession = sessionMap.get("code");
            if(!StringUtils.equals(codeInSession, imageCode)){
                log.warn("图片验证码错误,codeInSession={}", codeInSession);
                return false;
            }
            return true;
        }else {
            return false;
        }

    }

    /**
     * 验证码过期校验
     * @param request
     * @return
     */
    public static Boolean IsExpired(HttpServletRequest request){
        Logger log = LogUtils.get(ValidateImageCode.class);
        HttpSession session = request.getSession();
//        从session中获取过期时间
        Map<String,String> sessionMap = (Map<String, String>) session.getAttribute(SESSION_KEY);
        String expireTime = sessionMap.get("expiredTime");
        if(StringUtils.isEmpty(expireTime)){
            return true;
        }
        if(System.currentTimeMillis()>Long.parseLong(expireTime)) {
            log.warn("验证码过期,过期时间为{}", expireTime);
            session.removeAttribute(SESSION_KEY);
            return true;
        }
        return false;
    }
}
