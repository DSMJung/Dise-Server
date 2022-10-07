package com.example.dise.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@Getter
public class UpdatePasswordRequest {

    @NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" +
            "?@]{8,20}$",
            message = "password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다.")
    private String password;

    @NotBlank(message = "new_password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" +
            "?@]{8,20}$",
            message = "new_password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다.")
    private String newPassword;
}
