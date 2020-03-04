package com.antiy.request;

import com.antiy.base.BasicRequest;
import io.swagger.annotations.ApiModelProperty;

/**
 * 描述:
 *
 * @author xuemeng
 * @create 2019-01-16 10:30
 */
public class BaseRequest extends BasicRequest {

    @ApiModelProperty("主键Id")
    private Integer id;
    @ApiModelProperty("类型：1，漏洞文件，2，审核材料文件")
    private Integer type;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
