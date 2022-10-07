package com.example.dise.domain.user.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateUserInfoRequest {

    @NotBlank(message = "name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @Size(max = 4, message = "name은 4자 이하여야 합니다.")
    private String name;
}
