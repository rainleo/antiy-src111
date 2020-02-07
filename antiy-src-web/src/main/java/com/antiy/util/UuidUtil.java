package com.antiy.util;

import java.util.UUID;

/**
 * @program kbms-parent
 * @description uuid工具类
 * @author wangqian
 * created on 2019-07-25
 * @version  1.0.0
 */
public class UuidUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
