package com.antiy.enums.user;

public enum VulTypeEnum {
                         WEB(1, "Web应用漏洞"), HOSTSYS(2, "主机系统漏洞"), MOBILEAPP(3, "移动APP漏洞"), WEAKPASS(4, "弱口令类漏洞");

    private Integer code;
    private String  msg;

    VulTypeEnum(Integer code, String msg) {
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
        for (VulTypeEnum typeEnum : VulTypeEnum.values()) {
            if (typeEnum.getCode().equals(code)) {
                return typeEnum.getMsg();
            }
        }
        return null;
    }

    public static String getType(Integer code) {
        switch (code) {
            case 1:
                return "WEB";
            case 2:
                return "HOSTSYS";
            case 3:
                return "MOBILEAPP";
            case 4:
                return "WEAKPASS";
        }
        return null;
    }
}
