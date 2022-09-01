package com.example.dise.domain.feed.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class FeedListResponse {

    private final List<FeedResponse> feedList;

    @Getter
    @Builder
    public static class FeedResponse {
        private final Integer feedId;
        private final String title;
        private final String content;
        private final LocalDateTime createdAt;
        private final String name;
    }

}
