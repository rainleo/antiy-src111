package com.antiy.validation;

/**
 * @description: 字段类型的校验器
 * @Author: zhangbing
 * @date: 2018/10/30 16:31
 */
public interface FieldValidator {

    /**
     * 检验某一些字段是否合法
     *
     * @param val 校验值
     * @return
     */
    boolean validate(Object val);

}
