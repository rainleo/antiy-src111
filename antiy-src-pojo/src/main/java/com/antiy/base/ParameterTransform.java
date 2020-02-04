package com.antiy.base;

import org.apache.commons.lang.StringUtils;

/**
 * 描述: 参数转换类
 *
 * @author xuemeng
 * @create 2019-03-19 15:10
 */
public class ParameterTransform {

    /**
     * @Author: xuemeng
     * @Description: 转换查询语句的特殊字符
     * @Date: 15:12 2019/3/19
     */
    public static String transSqlSpecChar(String originalChar) {
        if (StringUtils.isBlank(originalChar)) {
            return originalChar;
        }
        if (originalChar.contains("%") || originalChar.contains("_")) {
            return originalChar.replace("%", "\\%").replace("_", "\\_");
        }
        return originalChar;
    }
}
