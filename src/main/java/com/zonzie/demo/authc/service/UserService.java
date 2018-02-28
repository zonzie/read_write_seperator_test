package com.zonzie.demo.authc.service;

import com.zonzie.demo.authc.dto.entity.User;

/**
 * Created by zonzie on 2018/2/26.
 */
public interface UserService {
    User findUser(int userId);

    void updateUser(String password);
}
