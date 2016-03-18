package com.provence.common.util;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

/**
 * Created by panwang.chengpw on 5/7/15.
 */
public class FastJson {

    public static final Logger    logger              = LoggerFactory.getLogger(FastJson.class);

    public static SerializeConfig mapping             = new SerializeConfig();

    public static String          DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    static {
        mapping.put(Date.class, new SimpleDateFormatSerializer(DEFAULT_DATE_FORMAT));
    }

    public static <T> String toJson(Object obj) {
        if (obj == null) {
            return StringUtils.EMPTY;
        }
        return JSON.toJSONString(obj, mapping);
    }

    public static <T> T toObject(String json, Class<T> classType) {
        if (StringUtils.isBlank(json)) {
            return null;
        }

        return (T) JSON.parseObject(json, classType);
    }

    public static JSONObject toObject(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }
        return JSON.parseObject(json);
    }

    public static <T> List<T> toList(String json, Class<T> classType) {
        if (StringUtils.isBlank(json)) {
            return Collections.emptyList();
        }

        return (List<T>) JSON.parseArray(json, classType);
    }

    public static JSONArray toList(String json) {
        if (StringUtils.isBlank(json)) {
            return null;
        }

        return JSON.parseArray(json);
    }

}
