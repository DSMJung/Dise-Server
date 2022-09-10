package com.example.dise.domain.comment.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class UpdateCommentRequest {

    @NotBlank
    @Size(max = 1000)
    private String content;

}
