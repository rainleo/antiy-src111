package com.antiy.enums.user;

import java.util.List;

public enum VulStatusEnum {
                           WAIT_EXAMINE(1, "待审核"), PASS(2, "通过"), NO_PASS(3, "未通过");

    private Integer code;
    private String  msg;

    VulStatusEnum(Integer code, String msg) {
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
        for (VulStatusEnum statusEnum : VulStatusEnum.values()) {
            if (statusEnum.getCode().equals(code)) {
                return statusEnum.getMsg();
            }
        }
        return null;
    }
}
