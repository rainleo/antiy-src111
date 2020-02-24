package com.antiy.base;

/**
 * @description: 基本返回状态码, 系统需要自定义返回码继承此枚举即可
 * 
 *               <pre>
 *               枚举B开头为Basic简称为基础定义的状态码
 *               </pre>
 * 
 * @Author: zhangbing
 * @date: 2018/10/30 13:30
 */
public enum RespBasicCode {
    SUCCESS("200", "成功"),
    PARAMETER_ERROR("400", "参数异常"),

    ERROR("500", "异常错误"),
    BUSINESS_EXCEPTION("416","业务异常"),
    METHOD_NOT_ALLOWED("415","方法不允许"),
    BAD_REQUEST("400", "无效的请求"),
    NOT_FOUND("404", "资源不存在"),
    UNSUPPORTED_MEDIA_TYPE("415", "不支持的媒体类型"),
    IMAGE_CODE_EXPRIED("417","验证码过期"),
    IMAGE_CODE_ERROR("418","验证码错误"),
    /**
     * 权限相关
     */
    NOT_PERMISSION("403", "没有权限"),
    SYS_TOKEN_EXPIRE("421", "您的登录状态已经失效,请重新登录"),
    ACCOUNT_REPEAT_LOGIN("422","当前账号已有其他人使用，您被退出，请检查账号信息或联系管理员"),
    ACCOUNT_NOT_LOGIN("423","登录已过期，请重新登录"),
    ACCOUNT_LOGIN_ERROR("424","用户名或密码错误"),
    ACCOUNT_FORBIDDEN_OR_LOCKED("425", "您的账号状态已被禁用/锁定，请联系管理员"),
    ACCOUNT_FORCED_RETURN("426", "您的账号权限被修改，请重新登录"),
    SYS_TOKEN_INVALID("427", "无效令牌"),

    /**
     *  接口验签相关
     */
    SYS_LSH_NOT_EMPTY("428", "请求流水号不能为空"),
    SYS_SIGN_NOT_EMPTY("429", "请求签名信息不能为空"),
    SYS_LSH_UNVALID("430", "请求流水号验证未通过"),
    SYS_SIGN_UNVALID("431", "请求签名验证未通过"),
    SYS_LSH_NOT_REPEAT("432", "请求流水号必须唯一");

    /**
     * 返回状态码
     */
    private String resultCode;

    /**
     * 返回描述
     */
    private String resultDes;

    RespBasicCode(String resultCode, String resultDes) {
        this.resultCode = resultCode;
        this.resultDes = resultDes;
    }

    public String getResultCode() {
        return resultCode;
    }

    public String getResultDes() {
        return resultDes;
    }

    /**
     * 通过code 获取异常对象
     *
     * @param code
     * @return
     */
    public static RespBasicCode getByCode(String code) {
        if (code == null || "".equals(code)) {
            return null;
        }
        for (RespBasicCode respBasicCode : RespBasicCode.values()) {
            if (respBasicCode.getResultCode().equals(code)) {
                return respBasicCode;
            }
        }
        return RespBasicCode.SUCCESS;
    }
}
