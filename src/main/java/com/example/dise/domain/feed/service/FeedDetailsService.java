package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.response.FeedDetailsResponse;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.feed.exception.FeedNotFoundException;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedDetailsService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedDetailsResponse execute(Integer feedId) {

        User user = userFacade.getCurrentUser();
        Feed feed = getFeed(feedId);

        return FeedDetailsResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .createdAt(feed.getCreatedAt())
                .userName(user.getName())
                .build();
    }

    private Feed getFeed(Integer feedId) {

        return feedRepository.findById(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
