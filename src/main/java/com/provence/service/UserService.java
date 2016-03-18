package com.provence.service;

import com.provence.common.query.Pagination;
import com.provence.dto.UserDto;
import com.provence.entity.User;
import com.provence.mapper.query.UserQuery;

/**
 * Created by chengpan on 2016/2/22.
 */
public interface UserService {

    /**
     * @param user
     */
    void insert(User user);

    /**
     * 分页查询
     * @param query
     * @return
     */
    Pagination<UserDto> listUserPage(UserQuery query);

    void delete(Long userId);

}
