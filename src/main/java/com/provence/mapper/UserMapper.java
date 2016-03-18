package com.provence.mapper;

import java.util.List;

import com.provence.dto.UserDto;
import com.provence.entity.User;
import com.provence.mapper.query.UserQuery;

public interface UserMapper extends BaseMapper<User> {

    long countUser(UserQuery userQuery);

    List<UserDto> listUser(UserQuery query);
}
