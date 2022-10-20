package com.example.dise.domain.user.controller;

import com.example.dise.domain.user.controller.dto.request.UpdatePasswordRequest;
import com.example.dise.domain.user.controller.dto.request.UpdateUserInfoRequest;
import com.example.dise.domain.user.controller.dto.request.UserLoginRequest;
import com.example.dise.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.dise.domain.user.controller.dto.response.TokenResponse;
import com.example.dise.domain.user.controller.dto.response.UserInfoResponse;
import com.example.dise.domain.user.service.*;
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
    private final UpdateUserInfoService updateUserInfoService;
    private final GetUserInfoService getUserInfoService;
    private final WithdrawalService withdrawalService;
    private final UpdatePasswordService updatePasswordService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody @Valid UserSignUpRequest request) {
        userSignUpService.signUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid UserLoginRequest request) {
        return userLoginService.login(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping
    public void updatePassword(@RequestBody @Valid UpdatePasswordRequest request) {
        updatePasswordService.updatePassword(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping
    public void updateUserInfo(@RequestBody @Valid UpdateUserInfoRequest request) {
        updateUserInfoService.execute(request);
    }

    @GetMapping
    public UserInfoResponse getInfo() {
        return getUserInfoService.execute();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping
    public void withdrawal() {
        withdrawalService.execute();
    }

}
