package com.provence.mapper.query;

import com.provence.common.query.BaseQuery;

/**
 * Created by chengpan on 2016/3/4.
 */
public class UserQuery extends BaseQuery {

    private String name;
    private Long   id;
    private String phone;


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
