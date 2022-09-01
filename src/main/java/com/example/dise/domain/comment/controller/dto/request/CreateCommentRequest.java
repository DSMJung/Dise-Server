package com.example.dise.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class CreateCommentRequest {

    @NotNull(message = "내용은 null을 허용하지 않습니다.")
    private String content;
}
