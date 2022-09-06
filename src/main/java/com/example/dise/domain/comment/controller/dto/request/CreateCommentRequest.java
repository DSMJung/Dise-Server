package com.example.dise.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    @NotBlank
    @Size(max = 1000, message = "내용은 1000자 이내이고 Null을 허용하지 않습니다.")
    private String content;
}
