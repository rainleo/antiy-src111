package com.antiy.validation;

import com.antiy.exception.RequestParamValidateException;

/**
 * @auther: zhangbing
 * @date: 2018/11/22 10:22
 * @description: 对象校验器
 */
public interface ObjectValidator {
    /**
     *
     * 校验失败，直接返回异常
     * @return
     * @throws RequestParamValidateException
     */
    void validate() throws RequestParamValidateException;
}
