package com.provence.common.web.view;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;

/**
 * Created by chengpanwang on 3/18/16.
 */
public class DateFormatTool {


    public static String format(Date date) {
        if (date == null) {
            return StringUtils.EMPTY;
        }
        return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
    }
}
