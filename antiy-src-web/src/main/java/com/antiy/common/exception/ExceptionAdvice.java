package com.antiy.common.exception;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.antiy.base.ActionResponse;
import com.antiy.base.RespBasicCode;
import com.antiy.exception.BusinessException;
import com.antiy.exception.RequestParamValidateException;

/**
 * @author liuyu
 * @date
 *
 */
@ControllerAdvice
@ResponseBody
public class ExceptionAdvice {

    private static Logger LogUtils = LoggerFactory.getLogger(ExceptionAdvice.class);

    /**
     * 400 - Bad Request
     */
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ HttpMessageNotReadableException.class, MissingServletRequestParameterException.class,
                        TypeMismatchException.class })
    public ActionResponse handleHttpMessageNotReadableException(Exception e) {
        LogUtils.error(  "参数解析失败", e);
        return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, "参数解析失败");
    }

    /**
     * 404 - not found
     */
    // @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ NoHandlerFoundException.class, ConversionNotSupportedException.class })
    public ActionResponse handleNoSuchRequestHandlingMethodException(Exception e) {
        LogUtils.error( "找不到对应方法", e);
        return ActionResponse.fail(RespBasicCode.NOT_FOUND, "没有当前请求方法");
    }

    /**
     * 405 - Method Not Allowed
     */
    // @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ActionResponse handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        LogUtils.error( "不支持当前请求方法", e);
        return ActionResponse.fail(RespBasicCode.METHOD_NOT_ALLOWED, "不支持当前请求方法");
    }

    /**
     * 415 - Unsupported Media Type
     */
    // @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ActionResponse handleHttpMediaTypeNotSupportedException(Exception e) {
        LogUtils.error( "不支持当前媒体类型", e);
        return ActionResponse.fail(RespBasicCode.UNSUPPORTED_MEDIA_TYPE, "不支持当前媒体类型");
    }

    /**
     * 400 - Parameters validate Error
     */
    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ActionResponse handleValidationException(MethodArgumentNotValidException e) {
    // LogUtils.error( "服务运行异常", e);
    // List<ObjectError> objectError = e.getBindingResult().getAllErrors();
    // String errors = "";
    // for (int i = 0; i < objectError.size(); i++) {
    // errors += objectError.get(i).getDefaultMessage() + ",";
    // }
    // return ActionResponse.fail(RespBasicCode.BAD_REQUEST, "无效的请求");
    // }

    /**
     * 500 - Internal Server Error
     */
    // @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ActionResponse handleException(Exception e) {
        LogUtils.error( "服务运行异常", e);
        return ActionResponse.fail(RespBasicCode.ERROR, "服务器运行异常");
    }

    /**
     * 业务异常
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    public ActionResponse businessException(BusinessException e) {
        LogUtils.error( "业务异常", e);
        return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION, e.getMessage());
    }

    @ExceptionHandler(RequestParamValidateException.class)
    public ActionResponse requestParamException(RequestParamValidateException e) {
        LogUtils.error( "请求参数异常", e);
        return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, e.getMessage());
    }

    /**
     * 处理实体字段校验不通过异常
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ActionResponse validationError(MethodArgumentNotValidException e) {
        LogUtils.error("请求参数异常", e);
        BindingResult result = e.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        return ActionResponse.fail(RespBasicCode.PARAMETER_ERROR, fieldErrors.get(0).getDefaultMessage());
    }
}
