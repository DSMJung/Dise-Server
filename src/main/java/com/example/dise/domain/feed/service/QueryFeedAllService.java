package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.response.FeedListResponse;
import com.example.dise.domain.feed.controller.dto.response.FeedResponse;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFeedAllService {
    private final FeedRepository feedRepository;

    @Transactional
    public FeedListResponse execute() {
        List<FeedResponse> feedResponseList = feedRepository.findAllByOrderById()
                .stream()
                .map(this::feedBuilder)
                .collect(Collectors.toList());
        return new FeedListResponse(feedResponseList);
    }
    private FeedResponse feedBuilder(Feed feed) {
        return FeedResponse.builder()
                .feedId(feed.getId())
                .category(feed.getCategory())
                .content(feed.getContent())
                .name(feed.getUser().getName())
                .title(feed.getTitle())
                .build();
    }
}
