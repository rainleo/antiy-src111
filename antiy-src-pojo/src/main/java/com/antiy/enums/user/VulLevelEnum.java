package com.antiy.enums.user;

public enum VulLevelEnum {
                          HIGHRISK(1, "高危"), MIDDLERISK(2, "中危"), LOWRISK(3, "低危");

    // 1高危漏洞，2中危漏洞3.低危漏洞
    private Integer code;
    private String  msg;

    VulLevelEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsg(Integer code) {
        for (VulLevelEnum levelEnum : VulLevelEnum.values()) {
            if (levelEnum.getCode().equals(code)) {
                return levelEnum.getMsg();
            }
        }
        return null;
    }
}
