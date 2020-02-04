package com.antiy.base;

/**
 * @auther: zhangbing
 * @date: 2018/12/28 11:20
 * @description:
 */
public class ClientInfo {

  /** 操作员IP */
  private String operatorIp;

  /** 请求流水号 */
  private String requestId;

  /** 凭证 */
  private String token;

  public String getOperatorIp() {
    return operatorIp;
  }

  public void setOperatorIp(String operatorIp) {
    this.operatorIp = operatorIp;
  }

  public String getRequestId() {
    return requestId;
  }

  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


}
