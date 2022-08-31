package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.feed.exception.FeedNotFoundException;
import com.example.dise.domain.feed.exception.NotModifyFeedException;
import com.example.dise.domain.feed.facade.FeedFacade;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateFeedService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;

    @Transactional
    public void modifyFeed(Integer feedId, UpdateFeedRequest request) {
        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        if (!user.equals(feed.getUser())) {
            throw NotModifyFeedException.EXCEPTION;
        }

        feed.modifyFeed(request.getTitle(),
                request.getContent(),
                request.getCategory());
    }
}
