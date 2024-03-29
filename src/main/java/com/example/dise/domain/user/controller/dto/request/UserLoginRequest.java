package com.example.dise.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class UserLoginRequest {

    @NotBlank(message = "아이디는 공백, 띄어쓰기를 허용하지 않습니다.")
    private String accountId;

    @NotBlank(message = "비밀번호는 공백, 띄어쓰기를 허용하지 않습니다.")
    private String password;
}
