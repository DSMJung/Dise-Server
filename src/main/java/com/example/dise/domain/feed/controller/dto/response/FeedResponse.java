package com.example.dise.domain.feed.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FeedResponse {

    private final Integer feedId;
    private final String title;
    private final String content;
    private final LocalDateTime createdAt;
    private final String name;

}
