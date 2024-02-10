package com.jwt.jwtbase.controller;

import com.jwt.jwtbase.entity.User;
import com.jwt.jwtbase.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers() {
        userService.initRolesAndUser();
    }

    @PostMapping(path = "/registerNewUser")
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @GetMapping(path = "/forAdmin")
    public String forAdmin(){
        return "This URL is only accessible to admin";
    }

    @GetMapping(path = "/forUser")
    public String forUser() {
        return "This URL is only accessible for user";
    }
}
