package com.provence.common.result;

/**
 * Created by panwang.chengpw on 1/22/15.
 */
public enum AjaxResultStatusEnum {

    OK(200, "成功"), PARAM_ERROR(400, "参数错误"), NO_LOGIN(600, "没有登录"), ERROR(500, "系统错误");

    private int    code;
    private String name;

    private AjaxResultStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    public static AjaxResultStatusEnum fromCode(Integer code) {
        if (code == null) {
            return ERROR;
        }
        for (AjaxResultStatusEnum status : AjaxResultStatusEnum.values()) {
            if (status.getCode() == code) {
                return status;
            }
        }

        return ERROR;
    }
}
