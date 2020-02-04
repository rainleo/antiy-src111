package com.antiy.request;

import com.antiy.base.BasicRequest;
import com.antiy.base.DataTypeUtils;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang.StringUtils;

/**
 * 描述:
 *
 * @author xuemeng
 * @create 2019-01-16 10:30
 */
public class BaseRequest extends BasicRequest {

    @ApiModelProperty("主键Id")
    private String stringId;

    public String getStringId() {
        return stringId;
    }

    public void setStringId(String stringId) {
        this.stringId = stringId;
    }

    /**
     * 数据拷贝会根据类型和方法拷贝，类型不正确则无法拷贝
     * @return
     */
    public Integer getId() {
        return StringUtils.isNotBlank(stringId) ? DataTypeUtils.stringToInteger(stringId) : null;
    }

}
