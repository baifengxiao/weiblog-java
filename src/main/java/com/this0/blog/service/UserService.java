package com.this0.blog.service;

import com.this0.blog.pojo.User;

public interface UserService {
    User login(User user);

    User showUserByUid(Integer uid);

    Integer changeUser(User user);
}
