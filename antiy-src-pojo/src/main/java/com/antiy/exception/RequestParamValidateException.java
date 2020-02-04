package com.antiy.exception;

/**
 * @auther: zhangbing
 * @date: 2018/11/21 16:16
 * @description: 请求参数异常
 */
public class RequestParamValidateException extends BusinessException {

    public RequestParamValidateException() {
        super();
    }

    public RequestParamValidateException(String msg) {
        super(msg);
    }

    public RequestParamValidateException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public RequestParamValidateException(Throwable throwable) {
        super(throwable);
    }

    public RequestParamValidateException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
