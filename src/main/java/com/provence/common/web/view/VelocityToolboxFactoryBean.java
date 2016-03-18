package com.provence.common.web.view;

import java.util.Map;

import org.apache.commons.lang3.ClassUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by chengpanwang on 3/18/16.
 */
public class VelocityToolboxFactoryBean {

    private static final Logger logger = LoggerFactory.getLogger(VelocityToolboxFactoryBean.class);

    private Map<String, Object> tools;

    public Map<String, Object> getTools() {
        return tools;
    }

    public void setTools(Map<String, Object> tools) {
        for (Map.Entry<String, Object> entry : tools.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            logger.info("载入velocty tool 类 : {}", entry.getValue());
            try {
                Class<?> toolClass = ClassUtils.getClass(entry.getValue().toString());
                entry.setValue(toolClass);
            } catch (ClassNotFoundException e) {
                logger.error("没有找到velocty tool 类, 类名:{}", entry.getValue());

            }
        }
        this.tools = tools;
    }

}
