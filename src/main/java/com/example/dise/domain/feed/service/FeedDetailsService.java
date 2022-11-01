package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.response.FeedDetailsResponse;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.facade.FeedFacade;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class FeedDetailsService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public FeedDetailsResponse execute(Integer feedId) {

        Feed feed = feedFacade.getFeedById(feedId);

        return FeedDetailsResponse.builder()
                .feedId(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .createdAt(feed.getCreatedAt())
                .userName(feed.getUserName())
                .isMine(getIsMine(feed.getUserId()))
                .build();
    }

    private boolean getIsMine(Integer id) {
        return userFacade.getUserId().equals(id);
    }
}
