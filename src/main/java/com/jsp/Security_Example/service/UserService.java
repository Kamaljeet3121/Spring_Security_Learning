package com.jsp.Security_Example.service;

import com.jsp.Security_Example.entity.User;

public interface UserService {
    public String greeting();

    User signup(User user);

    String signin(User user);
}
