package com.antiy.interceptor;

import com.antiy.base.ActionResponse;
import com.antiy.base.RespBasicCode;
import com.antiy.common.utils.LogUtils;
import com.antiy.consts.UserConstant;
import com.antiy.entity.user.LoginUser;
import com.antiy.util.JsonUtil;
import com.antiy.util.LoginTipHolder;
import com.antiy.util.LoginUserUtil;
import com.antiy.util.TokenStoreUtil;
import com.antiy.util.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @program antiy-src-parent
 * @description 用户拦截器
 * @author wangqian
 * created on 2020-02-06
 * @version  1.0.0
 */
@Component
public class UserInterceptor implements HandlerInterceptor {
    private Logger log = LogUtils.get(this.getClass());
    @Resource
    private LoginUserUtil loginUserUtil;
    @Resource
    private JwtUtil jwtUtil;
    @Value("${auth.switch:false}")
    private  Boolean isAuthentication;
    private boolean isPass;
    /**
     * 不校验登陆的接口
     */
    @Value("${permit.url:}")
    private String permitUrl;



    /**
     * 不校验权限的【如果要校验权限，必须校验登录】
     */
    private String[] urlss = new String[]{
            "/api/v1/user/login",
            "/api/v1/user/save"
    };

    /**
     *
     * @param request 请求对象
     * @param response 响应流
     * @param handler 处理器
     * @return 只有返回true才会继续向下执行，返回false取消当前请求
     * @throws Exception 业务异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!isAuthentication) {
            return true;
        }
        String[] urls = permitUrl.split(",");
        //是否需要放行
        isPass = !isAuthentication;


        //全路径
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
        //请求全路径
        String requestURI = request.getRequestURI();
        //请求路径
        String path = request.getServletPath();
        log.warn("========登录、权限校验拦截器======="+"path:"+basePath+requestURI);

        //是否校验登录
        if (!isCheckUrl(request,urls)){
            return true;
        }

        ActionResponse apiResult;
        //是否放行总开关
        Claims claims ;
        //校验登录
        String token = request.getHeader("token");
        //如果从header里面获取token失败，从url里面去取
        if (token == null) {
            token = request.getParameter("token");
        }
        //校验token
        if(token == null){
            log.debug("=====================user token不存在=========================");
            //token不存在
            apiResult = ActionResponse.fail(RespBasicCode.ACCOUNT_NOT_LOGIN, RespBasicCode.ACCOUNT_NOT_LOGIN.getResultDes());

            doReturn(response, apiResult);

            return isPass;

        }else {
            claims = jwtUtil.getClaims(token);
            //令牌无效
            if(claims ==null){
                log.debug("=====================user 令牌无效========================");
                apiResult = ActionResponse.fail(RespBasicCode.SYS_TOKEN_INVALID, RespBasicCode.SYS_TOKEN_INVALID.getResultDes());
                doReturn(response,apiResult);
                return isPass;
            }
            //获取 token 中的信息
            String userName = (String) claims.get("username");
            Long tokenKey = (Long) claims.get("userId");
            String name = (String) claims.get("name");
            log.info("当前访问用户token信息为bh:{},username:{},name:{}",tokenKey,userName,name);
            String oldToken = TokenStoreUtil.get(tokenKey);
            //令牌过期
            if(oldToken == null){
                log.debug("=====================user 登录信息过期====================");
                apiResult = ActionResponse.fail(RespBasicCode.SYS_TOKEN_EXPIRE, RespBasicCode.SYS_TOKEN_EXPIRE.getResultDes());
                doReturn(response,apiResult);
                return isPass;
            }

           /* if(!token.equals(oldToken)){
                log.debug("=====================user 用户已在其他设备登录============");
                //token,用户已在其他设备登录
                apiResult = ActionResponse.fail(RespBasicCode.ACCOUNT_REPEAT_LOGIN, RespBasicCode.ACCOUNT_REPEAT_LOGIN.getResultDes());
                doReturn(response,apiResult);
                return isPass;
            }*/
            //未登录
            if(tokenKey == null ){
                log.debug("====================user 未登录============================");
                //没有登陆，返回状态码
                apiResult = ActionResponse.fail(RespBasicCode.ACCOUNT_NOT_LOGIN, RespBasicCode.ACCOUNT_NOT_LOGIN);
                doReturn(response,apiResult);
                return isPass;
            }else{
                if (LoginTipHolder.containsKey(tokenKey)) {
                    apiResult = ActionResponse.fail(RespBasicCode.ACCOUNT_FORCED_RETURN, LoginTipHolder.getTip(tokenKey));
                    doReturn(response,apiResult);
                    TokenStoreUtil.removeToken(token);
                    log.warn("您的账号{}已被禁用或权限被修改,您已被强制退出,注销token",tokenKey);
                    return isPass;
                }
                log.debug("=====================更新 user token有效期===================");
                //更新令牌有效期
                TokenStoreUtil.relongExpired(token, System.currentTimeMillis() + UserConstant.EXPIRE);
                if (loginUserUtil.isSystem()) {
                    LoginUser userinfo = TokenStoreUtil.get(token);
                    loginUserUtil.setUser(userinfo);
                    log.warn("当前登录用户为："+userName);
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    {
        //请求处理完后清空当前线程缓存的用户信息
        loginUserUtil.setUser(null);

    }

    private boolean isCheckUrl(HttpServletRequest request, String[] urls) {
        boolean result = true;
        //请求路径
        String path = request.getServletPath();
        //不检验登陆的url
        for (String url : urls) {
            //放行url地址，是否为合法url
            boolean isLegal = url != null && !url.trim().isEmpty();
            if (isLegal && url.equals(path)) {
                result = false;
                break;

            }
        }
        return result;
    }


    /**
     * 回调信息
     * @param response 响应对象
     * @param actionResponse 响应内容
     * @throws IOException io异常
     */
    private void doReturn(HttpServletResponse response, ActionResponse actionResponse) throws IOException {
        if (isPass) {
            return;
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out ;
        out = response.getWriter();
        out.append(JsonUtil.object2Json(actionResponse));
        out.flush();
        out.close();
    }
}
