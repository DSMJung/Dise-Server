package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.response.FeedListResponse;
import com.example.dise.domain.feed.controller.dto.response.FeedResponse;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryMyFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedListResponse myFeedList() {
        User user = userFacade.getCurrentUser();

        List<FeedResponse> feedList = feedRepository.findAllByUserIdOrderByCreatedAtDesc(user.getId())
                .stream()
                .map(this::buildMyFeedList)
                .collect(Collectors.toList());

        return new FeedListResponse(feedList);
    }

    private FeedResponse buildMyFeedList(Feed feed) {
        return FeedResponse.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .createdAt(feed.getCreatedAt())
                .name(feed.getUser().getName())
                .build();
    }

}
