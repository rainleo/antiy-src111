package com.antiy.redis;


import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author shenliang
 * @since 2019-01-08
 */

public class Code {


private static final long serialVersionUID = 1L;
    private Integer id;
    @ApiModelProperty("")
    private String code;
    @ApiModelProperty("")
    private String value;
    @ApiModelProperty("")
    private Integer codeTypeId;
    @ApiModelProperty("")
    private Integer status;



    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCode() {
        return Integer.valueOf(code);
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
        return "Code{" +
                ", code=" + code +
                ", value=" + value +
                ", codeTypeId=" + codeTypeId +
                ", status=" + status +
                "}";
    }
}