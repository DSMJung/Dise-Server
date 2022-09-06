package com.example.dise.domain.feed.controller.dto.response;

import com.example.dise.domain.feed.domain.type.Category;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class FeedResponse {
    private final Integer feedId;
    private final String title;
    private final String content;
    private final Category category;
    private final String name;
}