package com.example.dise.domain.feed.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class FeedListResponse {
    private final List<FeedResponse> feedResponseList;
}
