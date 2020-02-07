package com.antiy.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.StringWriter;
import java.text.SimpleDateFormat;

/**
 * @author shenliang
 * @since 2019-01-03
 */
public class JsonUtil {
    public static final Logger logger = LoggerFactory.getLogger(DateUtils.class);
    private static ObjectMapper object2JsonMapper;
    private static ObjectMapper object2JsonWithNullMapper;
    private static ObjectMapper json2ObjectMapper;
    static {
        object2JsonMapper = new ObjectMapper();
        object2JsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        object2JsonMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        object2JsonMapper.enable(SerializationFeature.INDENT_OUTPUT);
        object2JsonWithNullMapper = new ObjectMapper();
        object2JsonWithNullMapper.enable(SerializationFeature.INDENT_OUTPUT);
        object2JsonWithNullMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        json2ObjectMapper = new ObjectMapper();
        json2ObjectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        json2ObjectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        json2ObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
    }

    /**
     * 实体类转json字符串，空值忽略
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        StringWriter stringWriter = new StringWriter();
        try {
            object2JsonMapper.writeValue(stringWriter, object);
        } catch (Exception e) {
            logger.error("object2Json方法调用失败，入参：{}", object, e);
        }
        return stringWriter.toString();
    }

    /**
     * 实体类转json字符串，空值为null
     * @param object
     * @return
     */
    public static String object2JsonWithNull(Object object) {
        StringWriter stringWriter = new StringWriter();
        try {
            object2JsonWithNullMapper.writeValue(stringWriter, object);
        } catch (Exception e) {
            logger.error("object2JsonWithNull方法调用失败，入参：{}", object, e);
        }
        return stringWriter.toString();
    }

    /**
     * json字符串转实体类
     * @param json
     * @param clazz
     * @return
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        T t = null;
        try {
            t = json2ObjectMapper.readValue(json, clazz);
        } catch (Exception e) {
            logger.error("json2Object方法调用失败，入参：{}", clazz, e);
        }
        return t;
    }
}
