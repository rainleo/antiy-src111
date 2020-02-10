package com.antiy.interceptor;

import com.antiy.annotation.HavePermission;
import com.antiy.entity.user.LoginUser;
import com.antiy.exception.BusinessException;
import com.antiy.util.LoginUserUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program antiy-src-parent
 * @description 接口权限aop
 * @author wangqian
 * created on 2020-02-07
 * @version  1.0.0
 */
@Component
@Aspect
@Order(1)
public class ApiAop {

    @Autowired
    private LoginUserUtil loginUserUtil;

    @Pointcut("@annotation(com.antiy.annotation.HavePermission)")
    public void permiss() {
    }

    @Before("permiss()&&@annotation(permission)")
    public void doBefore(JoinPoint joinPoint, HavePermission permission) {
        LoginUser user = loginUserUtil.getUser();
        if (user != null) {
            String qx = permission.value();
            List<String> menus = user.getMenus();
            if (!menus.contains(qx)) {
                throw new BusinessException("对不起，您没有权限");
            }
        }
    }
}
