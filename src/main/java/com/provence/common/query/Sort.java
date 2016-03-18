package com.provence.common.query;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by panwang.chengpw on 1/22/15.
 */
public class Sort {

    public static final Sort    EMPTY    = new Sort();

    private static final String dirArr[] = { "desc", "asc" };

    private String              dir      = "desc";
    private String              property;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        if (ArrayUtils.contains(dirArr, dir)) {
            this.dir = dir;
        }
    }
}
