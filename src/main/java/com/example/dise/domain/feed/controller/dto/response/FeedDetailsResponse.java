package com.example.dise.domain.feed.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FeedDetailsResponse {

    private final String title;
    private final String content;
    private final String userName;
    private final LocalDateTime createdAt;

}
