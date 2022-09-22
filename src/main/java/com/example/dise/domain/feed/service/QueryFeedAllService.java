package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.response.FeedElement;
import com.example.dise.domain.feed.controller.dto.response.FeedListResponse;
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

    @Transactional(readOnly = true)
    public FeedListResponse execute() {
        List<FeedElement> feedResponseList = feedRepository.findAllByOrderById()
                .stream()
                .map(this::feedBuilder)
                .collect(Collectors.toList());
        return new FeedListResponse(feedResponseList);
    }

    private FeedElement feedBuilder(Feed feed) {

        return FeedElement.builder()
                .feedId(feed.getId())
                .content(feed.getContent())
                .name(feed.getUser().getName())
                .createdAt(feed.getCreatedAt())
                .title(feed.getTitle())
                .build();
    }
}
