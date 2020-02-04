package com.antiy.response.user;

/**
 * @author wangyajing
 */
public class ApiResponse {
    private static final long serialVersionUID = 1L;

    /**
     * 接口编号
     */
    private String bh;
    /**
     * 接口名称
     */
    private String name;
    /**
     * 接口url
     */
    private String url;
    /**
     * 请求方法 1、get 2、post 3、put 4、delete
     */
    private Integer method;

    /**
     * 请求方法 get post put delete
     */
    private String methodDesc;

    public String getMethodDesc() {
        return methodDesc;
    }

    public void setMethodDesc(String methodDesc) {
        this.methodDesc = methodDesc;
    }

    public String getBh() {
        return bh;
    }

    public void setBh(String bh) {
        this.bh = bh;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Integer getMethod() {
        return method;
    }

    public void setMethod(Integer method) {

        this.method = method;

    }


    @Override
    public String toString() {
        return "Api{" +
                ", bh=" + bh +
                ", name=" + name +
                ", url=" + url +
                ", method=" + method +
                "}";
    }
}
