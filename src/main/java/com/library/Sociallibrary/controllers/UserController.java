package com.library.Sociallibrary.controllers;

import com.library.Sociallibrary.Dto.AuthDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.Sociallibrary.Entities.User;
import com.library.Sociallibrary.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.Map;

@AllArgsConstructor
@RestController
public class UserController {

    private UserService userService;
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/register")
    public void register(@RequestBody User user){
        this.userService.createUser(user);
    }

    @PostMapping(path = "login")
    public Map<String string> login(@RequestBody AuthDto authDto){

    }


}
