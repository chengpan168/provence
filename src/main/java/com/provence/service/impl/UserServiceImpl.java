package com.provence.service.impl;

import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import com.provence.common.query.Pagination;
import com.provence.dto.UserDto;
import com.provence.entity.User;
import com.provence.mapper.UserMapper;
import com.provence.mapper.query.UserQuery;
import com.provence.service.UserService;

/**
 * Created by chengpan on 2016/2/22.
 */
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public Pagination<UserDto> listUserPage(UserQuery query) {
        long count = userMapper.countUser(query);

        List<UserDto> list = Collections.emptyList();
        if (count > 0) {
            list = userMapper.listUser(query);
        }

        return new Pagination<UserDto>(query, list, count);
    }

    @Override
    public void delete(Long userId) {
        userMapper.deleteByPrimaryKey(userId);
    }
}
