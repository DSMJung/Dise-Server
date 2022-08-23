package com.example.dise.domain.user.controller;

import com.example.dise.domain.user.controller.dto.request.UserLoginRequest;
import com.example.dise.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.dise.domain.user.service.UserLoginService;
import com.example.dise.domain.user.service.UserSignUpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserSignUpService userSignUpService;
    private final UserLoginService userLoginService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.signUp(request);
    }

    @PostMapping("/login")
    public String login(@RequestBody @Valid UserLoginRequest request) {
        return userLoginService.login(request);
    }
}
