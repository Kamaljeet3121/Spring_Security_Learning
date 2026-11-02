package com.jsp.Security_Example.controller;

import com.jsp.Security_Example.entity.User;
import com.jsp.Security_Example.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @PostMapping("/greet")
    public String getUser() {
        return service.greeting();
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return service.signup(user);
    }

    @GetMapping("/signin")
    public String signin(@RequestBody User user) {
        return service.signin(user);
    }
}
