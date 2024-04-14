package com.library.Sociallibrary.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.Sociallibrary.Entities.User;
import com.library.Sociallibrary.Services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;

    @PostMapping(path = "/register")
    public void register(@RequestBody User user){
        this.userService.createUser(user);
    }
}
