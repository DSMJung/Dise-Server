package com.example.dise.domain.comment.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentElement {

    private final Integer commentId;
    private final String content;
    private final String name;
    private final boolean isMine;
}
