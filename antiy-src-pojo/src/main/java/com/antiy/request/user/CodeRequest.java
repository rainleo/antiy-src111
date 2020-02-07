package com.antiy.request.user;

/**
 * <p>
 * CodeRequest 请求对象
 * </p>
 *
 * @author shenliang
 * @since 2019-01-08
 */

public class CodeRequest {

    private Integer id;


    private String code;

    private String value;

    private Integer codeTypeId;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
    return code;
    }

    public void setCode(String code) {
        this.code = code;
        }


    public String getValue() {
    return value;
    }

    public void setValue(String value) {
        this.value = value;
        }


    public Integer getCodeTypeId() {
    return codeTypeId;
    }

    public void setCodeTypeId(Integer codeTypeId) {
        this.codeTypeId = codeTypeId;
        }


    public Integer getStatus() {
    return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
        }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append("\"id\":")
                .append(id);
        sb.append(",\"code\":\"")
                .append(code).append('\"');
        sb.append(",\"value\":\"")
                .append(value).append('\"');
        sb.append(",\"codeTypeId\":")
                .append(codeTypeId);
        sb.append(",\"status\":")
                .append(status);
        sb.append('}');
        return sb.toString();
    }

}