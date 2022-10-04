package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.response.FeedElement;
import com.example.dise.domain.feed.controller.dto.response.FeedListResponse;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import com.example.dise.domain.feed.domain.type.Category;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SearchFeedService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedListResponse execute(String keyword) {

        List<FeedElement> feedElementList = feedRepository.findByTitleContainingOrderByCreatedAtDesc(keyword)
                .stream()
                .map(this::feedBuilder)
                .collect(Collectors.toList());

        return new FeedListResponse(feedElementList);
    }

    private FeedElement feedBuilder(Feed feed) {
        return FeedElement.builder()
                .feedId(feed.getId())
                .content(feed.getContent())
                .name(feed.getUserName())
                .createdAt(feed.getCreatedAt())
                .title(feed.getTitle())
                .build();
    }
}
