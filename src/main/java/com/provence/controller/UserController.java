package com.provence.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.provence.common.result.AjaxResult;
import com.provence.dto.UserDto;
import com.provence.enums.SexEnum;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.provence.common.query.Pagination;
import com.provence.common.web.controller.BaseController;
import com.provence.entity.User;
import com.provence.mapper.query.UserQuery;
import com.provence.service.UserService;
import com.google.common.collect.Maps;

@RequestMapping("/user")
@Controller
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @ModelAttribute
    public void userSexs(Model model) {
        model.addAttribute("sexs", Arrays.asList(SexEnum.values()));
    }

    @RequestMapping("/edit.htm")
    public ModelAndView edit(@RequestParam(value = "name", required = false) List<String> nameList, UserQuery query) {
        ModelAndView mv = new ModelAndView();

        logger.info("name:{}", nameList);


        Map<String, Object> param1 = Maps.newHashMap();
        Lists.newArrayList();

        return mv;
    }

    @RequestMapping("/add.htm")
    public ModelAndView add(User user) {
        logger.info("添加新用户，用户信息：{}", user);

        ModelAndView mv = newModelAndView("/user/edit");
        String msg = StringUtils.EMPTY;
        if (user == null || StringUtils.isAnyBlank(user.getName(), user.getPhone())) {
            msg = "带*号部分不能为空";
            mv.addObject("msg", msg);
            return mv;
        }

        if (StringUtils.length(user.getName()) > 10 || StringUtils.length(user.getPhone()) > 20 || StringUtils.length(user.getAddress()) > 200
            || StringUtils.length(user.getSex()) > 10) {
            msg = "字段长度超过最大长度";
            mv.addObject("msg", msg);
            return mv;
        }

        userService.insert(user);

        msg = "用户添加成功";
        mv.addObject("msg", msg);

        return mv;
    }

    @RequestMapping("/list.htm")
    public ModelAndView list(UserQuery userQuery) {
        logger.info("用户列表查询：{}", userQuery);

        ModelAndView mv = newModelAndView("/user/list");

        Pagination<UserDto> userPage = userService.listUserPage(userQuery);

        logger.info("查询用户结果:{}", userPage);
        mv.addObject("userPage", userPage);

        return mv;
    }


    @RequestMapping("/delete/{userId}.json")
    @ResponseBody
    public AjaxResult delete(@PathVariable Long userId) {
        logger.info("用户删除, id：{}", userId);
        AjaxResult ajaxResult = newAjaxResult();

        userService.delete(userId);


        return ajaxResult;
    }




}
