package com.antiy.enums.user;

/**
 *
 * @author wangyajing
 */
public enum ApiMethodEnum {
    GET(1, "get"), POST(2, "post"), PUT(3, "put"), DELETE(4, "delete");
    private Integer code;
    private String name;

    ApiMethodEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param code
     * @return name
     */
    public static ApiMethodEnum getNameByCode(Integer code){
        if(code != null){
            for (ApiMethodEnum method:ApiMethodEnum.values()) {
                if(method.getCode().equals(code)){
                    return method;
                }
            }
        }
        return null;
    }
}
