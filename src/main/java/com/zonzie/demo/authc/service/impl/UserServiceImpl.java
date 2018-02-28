package com.zonzie.demo.authc.service.impl;

import com.zonzie.demo.authc.dto.entity.User;
import com.zonzie.demo.authc.mapper.UserMapper;
import com.zonzie.demo.authc.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by zonzie on 2018/2/26.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findUser(int userId) {
        return userMapper.findByUsername(userId);
    }

    @Override
    public void updateUser(String password) {
        userMapper.updateUser(password);
    }
}
