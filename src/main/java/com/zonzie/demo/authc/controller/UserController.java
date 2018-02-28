package com.zonzie.demo.authc.controller;

import com.zonzie.demo.authc.dto.entity.User;
import com.zonzie.demo.authc.service.UserService;
import com.zonzie.demo.common.BaseResponse;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by zonzie on 2018/2/26.
 */
@RestController
@Api(description = "读写分离测试")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "read")
    public BaseResponse readUser(int userId) {
        User user = userService.findUser(userId);
        return new BaseResponse(0,user.getUsername());
    }

    @GetMapping(value = "write")
    public BaseResponse write(String password) {
        userService.updateUser(password);
        return new BaseResponse(0,"bingo");
    }
}
