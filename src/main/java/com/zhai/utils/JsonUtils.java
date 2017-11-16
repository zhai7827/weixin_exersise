package com.zhai.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * JSON工具类
 */
public final class JsonUtils {

    private static final ObjectMapper om = new ObjectMapper();

    static {
        om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        om.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        om.setSerializationInclusion(Include.NON_DEFAULT);
        // om.setDateFormat(new SimpleDateFormat(Constants.DATE_FORMAT_DEFAULT));
        // om.enableDefaultTyping();
    }

    public JsonUtils() {

    }

    /**
     * 对象转换为JSON字符串
     */
    public static String object2Json(final Object obj) throws JsonProcessingException, Exception {
        return om.writeValueAsString(obj);
    }

    /**
     * JSON字符串转换为对象
     */
    public static Object json2Object(final String jsonString, final Class<?> clazz)
            throws JsonProcessingException, Exception {
        return jsonString == null || jsonString.length() == 0 ? null : om.readValue(jsonString, clazz);
    }

    /**
     * JSON字符串转换为Collection、Map
     */
    public static Object json2Collections(final String jsonString, final Class<?> collectionClass,
            final Class<?>... elementClass) throws JsonProcessingException, Exception {
        JavaType valueType = om.getTypeFactory().constructParametrizedType(collectionClass, collectionClass, elementClass);
        return jsonString == null || jsonString.length() == 0 ? null : om.readValue(jsonString, valueType);
    }

}
