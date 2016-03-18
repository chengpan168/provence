package com.provence.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.provence.dto.UserDto;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.provence.common.query.Pagination;
import com.provence.common.web.controller.BaseController;
import com.provence.mapper.query.UserQuery;
import com.provence.service.UserService;
import com.google.common.collect.Maps;

@Controller
public class HomeController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/home.htm")
    public ModelAndView home(@RequestParam(value = "name", required = false) List<String> nameList, UserQuery query) {
        ModelAndView mv = new ModelAndView();

        //        if (nameList != null && !nameList.isEmpty()) {
        if (!CollectionUtils.isEmpty(nameList)) {
            //            return mv;


        for (String name : nameList) {
            //            if (name != null && !name.isEmpty()) {
            if (StringUtils.isNotBlank(name)) {
                // TODO
            }
        }
        }

        Pagination<UserDto> userPagination = userService.listUserPage(query);

        mv.addObject("userPagination", userPagination);

        //        Map<String, Object> param = new HashMap<String, Object>;
        Map<String, Object> param = Maps.newHashMapWithExpectedSize(2);

        return mv;
    }
}
