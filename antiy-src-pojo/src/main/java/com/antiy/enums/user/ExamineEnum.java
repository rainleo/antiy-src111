package com.antiy.enums.user;

public enum ExamineEnum {
                         PASS(1, "通过"), NOPASS(2, "不通过");

    // 1高危漏洞，2中危漏洞3.低危漏洞
    private Integer code;
    private String  msg;

    ExamineEnum(Integer code, String msg) {
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
        for (ExamineEnum examineEnum : ExamineEnum.values()) {
            if (examineEnum.getCode().equals(code)) {
                return examineEnum.getMsg();
            }
        }
        return null;
    }
}
