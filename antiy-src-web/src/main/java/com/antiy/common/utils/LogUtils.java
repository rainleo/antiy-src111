package com.antiy.common.utils;

import com.antiy.base.ClientInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import java.util.Objects;
import java.util.UUID;

/**
 * @author liuyu
 * @date
 */
public class LogUtils {

  /**
   * @param clazz 日志发出的类
   * @return @MethodName：get @ReturnType：Logger
   * @description： @Creator：liuyu @CreateTime：2017年5月20日下午1:37:13 @Modifier： @ModifyTime：
   */
  public static Logger get(Class<?> clazz) {
    return LoggerFactory.getLogger(clazz);
  }

  /**
   * @param name 自定义的日志发出者名称
   * @return @MethodName：get @ReturnType：Logger
   * @description： @Creator：liuyu @CreateTime：2017年5月20日下午1:37:26 @Modifier： @ModifyTime：
   */
  public static Logger get(String name) {
    return LoggerFactory.getLogger(name);
  }

  /**
   * @return @MethodName：get @ReturnType：Logger
   * @description：
   *     获得日志，自动判定日志发出者 @Creator：liuyu @CreateTime：2017年5月20日下午1:37:41 @Modifier： @ModifyTime：
   */
  public static Logger get() {
    StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
    return LoggerFactory.getLogger(stackTrace[2].getClassName());
  }

  /**
   * @param log 日志对象
   * @param format 格式文本，{} 代表变量
   * @param arguments 变量对应的参数 @MethodName：trace @ReturnType：void
   * @description：
   *     Trace等级日志，小于Debug @Creator：liuyu @CreateTime：2017年5月20日下午1:36:28 @Modifier： @ModifyTime：
   */
  public static void trace(Logger log, String format, Object... arguments) {
    if (log.isTraceEnabled()) {
      initMDC();
      log.trace(format, arguments);
    }
  }

  /**
   * @param log 日志对象
   * @param format 格式文本，{} 代表变量
   * @param arguments 变量对应的参数 @MethodName：debug @ReturnType：void
   * @description：
   *     Debug等级日志，小于Info @Creator：liuyu @CreateTime：2017年5月20日下午1:38:17 @Modifier： @ModifyTime：
   */
  public static void debug(Logger log, String format, Object... arguments) {
    if (log.isDebugEnabled()) {
      initMDC();
      log.debug(format, arguments);
    }
  }

  /**
   * @param log 日志对象
   * @param format 格式文本，{} 代表变量
   * @param arguments 变量对应的参数 @MethodName：info @ReturnType：void
   * @description： info信息记录 @Creator：liuyu @CreateTime：2017年5月20日 @Modifier： @ModifyTime：
   */
  public static void info(Logger log, String format, Object... arguments) {
    if (log.isInfoEnabled()) {
      initMDC();
      log.info(format, arguments);
    }
  }

  /**
   * @param log 日志对象
   * @param format 格式文本，{} 代表变量
   * @param arguments 变量对应的参数 @MethodName：warn @ReturnType：void
   * @description
   *     ：Warn等级日志，小于Error @Creator：liuyu @CreateTime：2017年5月20日下午1:40:27 @Modifier： @ModifyTime：
   */
  public static void warn(Logger log, String format, Object... arguments) {
    if (log.isWarnEnabled()) {
      initMDC();
      log.warn(format, arguments);
    }
  }

  /**
   * @param log 　　　日志对象
   * @param e 　　　　　需在日志中堆栈打印的异常
   * @param format 　　格式文本，{} 代表变量
   * @param arguments 　　变量对应的参数 @MethodName：warn @ReturnType：void
   * @description：调用日志 warn信息记录
   *     每一个会话，唯一标示UUID串联所有日志 @Creator：liuyu @CreateTime：2017年5月20日下午1:43:52 @Modifier： @ModifyTime：
   */
  public static void warn(Logger log, Throwable e, String format, Object... arguments) {
    if (log.isWarnEnabled()) {
      initMDC();
      log.warn(format(format, arguments), e);
    }
  }

  /**
   * @param log 日志对象
   * @param format 格式文本，{} 代表变量
   * @param arguments 变量对应的参数 @MethodName：error @ReturnType：void
   * @description： @Creator：liuyu @CreateTime：2017年5月20日下午1:35:12 @Modifier： @ModifyTime：
   */
  public static void error(Logger log, String format, Object... arguments) {
    if (log.isErrorEnabled()) {
      initMDC();
      log.error(format, arguments);
    }
  }

  /**
   * @param log 日志对象
   * @param e 需在日志中堆栈打印的异常
   * @param format 格式文本，{} 代表变量
   * @param arguments 变量对应的参数 @MethodName：error @ReturnType：void
   * @description： @Creator：liuyu @CreateTime：2017年5月20日下午1:33:33 @Modifier： @ModifyTime：
   */
  public static void error(Logger log, Throwable e, String format, Object... arguments) {
    if (log.isErrorEnabled()) {
      initMDC();
      log.error(format(format, arguments), e);
    }
  }

  /**
   * @param template 文本模板，被替换的部分用 {} 表示
   * @param values 参数值
   * @return 格式化后的文本 @MethodName：format @ReturnType：String
   * @description： @Creator：liuyu @CreateTime：2017年5月20日下午1:32:50 @Modifier： @ModifyTime：
   */
  private static String format(String template, Object... values) {
    return String.format(template.replace("{}", "%s"), values);
  }

  /**
   * @return @MethodName：get32UUID @ReturnType：String
   * @description： 获取32位UUID @Creator：liuyu @CreateTime：2017年5月20日下午1:32:10 @Modifier： @ModifyTime：
   */
  public static String get32UUID() {
    UUID uuid = UUID.randomUUID();
    String returnValue = uuid.toString();
    returnValue = returnValue.replace("-", "");
    return returnValue;
  }

  /**
   * @MethodName：initMDC @ReturnType：void
   *
   * @description：初始化MDC @Creator：daijie @CreateTime：2019/1/11
   *     9:55 @Modifier：daijie @ModifyTime：2019/1/11 9:55
   */
  public static void initMDC() {
    clearMDCParam();
    initMDCParam();
  }

  /**
   * @MethodName：clearMDCParam @ReturnType：void
   *
   * @description：
   *     清空并重新获取调用信息 @Creator：liuyu @CreateTime：2017年5月20日下午1:28:37 @Modifier：daijie @ModifyTime：2019年1月9日下午3:28:37
   */
  private static void clearMDCParam() {
    MDC.remove("userId");
    MDC.remove("userName");
    MDC.remove("requestId");
    MDC.remove("operatorIp");
    MDC.remove("token");
  }

  /**
   * @MethodName：initMDCParam @ReturnType：void
   *
   * @description： 初始化本地调用信息
   *     用户id，用户名，请求id，本地IP，token @Creator：liuyu @CreateTime：2017年5月20日下午1:28:37 @Modifier：daijie @ModifyTime：2019年1月9日下午3:28:37
   */
  private static void initMDCParam() {
    // 从LoginUserUtil获取用户信息
//    LoginUser loginUser = LoginUserUtil.getLoginUser();
//    if (Objects.nonNull(loginUser)) {
//      MDC.put("userId", loginUser.getStringId() != null ? loginUser.getStringId() : "");
//      MDC.put("userName", loginUser.getUsername());
//    } else {
      MDC.put("userId", "");
      MDC.put("userName", "");
//    }

    ClientInfo clientInfo = null;//LoginUserUtil.getCommonInfo();
    if (Objects.nonNull(clientInfo)) {
      MDC.put("requestId", clientInfo.getRequestId());
      MDC.put("operatorIp", clientInfo.getOperatorIp());
    } else {
      MDC.put("requestId", "");
      MDC.put("operatorIp", "");
    }
  }


}
