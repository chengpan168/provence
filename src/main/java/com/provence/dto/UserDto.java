package com.provence.dto;

import com.provence.entity.User;
import com.provence.enums.SexEnum;

public class UserDto extends User {

    private String sexName;

    public String getSexName() {
        if (sexName == null) {
            sexName = SexEnum.fromCode(getSex()).getName();
        }
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }
}
