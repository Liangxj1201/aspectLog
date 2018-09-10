package com.xjliang.aspect.controller;

import com.xjliang.aspect.entity.RespHead;
import com.xjliang.aspect.entity.Result;
import com.xjliang.aspect.entity.User;
import com.xjliang.aspect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getUser")
    public Result<User> getUser(){
        User user = new User();
        user.setName("xjliang");
        user.setAge(5);
        user=userService.getUser(user);
        Result<User> result =new Result<User>();
        RespHead respHead=new RespHead();
        result.setRespHead(respHead);
        result.setContent(user);
        return result;
    }
}
