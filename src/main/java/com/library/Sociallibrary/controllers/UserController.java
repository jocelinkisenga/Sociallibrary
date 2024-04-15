package com.library.Sociallibrary.controllers;

import com.library.Sociallibrary.Dto.AuthDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.library.Sociallibrary.Entities.User;
import com.library.Sociallibrary.Services.UserService;

import lombok.AllArgsConstructor;

import java.util.Map;

@Slf4j
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
    public Map<String, String> login(@RequestBody AuthDto authDto) {
      final   Authentication authenticate = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authDto.email(), authDto.password())
        );
      log.info("rsult {}", authenticate.isAuthenticated());
        return null;
}
}
