package com.antiy.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: 对于复杂的字段进行校验
 * 
 *               <pre>
 *     公共包仅仅定义了注解，但是没有定义AOP校验，业务系统需要使用注解进行字段校验需要些AOP
 *               </pre>
 * 
 * @Author: zhangbing
 * @date: 2018/10/30 16:29
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {

    /**
     * 校验器
     * @return
     */
    Class<? extends FieldValidator>[] validators();

    /**
     * message
     * @return
     */
    String message();
}
