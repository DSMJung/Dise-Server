package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.feed.exception.NotDeleteFeedException;
import com.example.dise.domain.feed.facade.FeedFacade;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteFeedService {

    private final UserFacade userFacade;
    private final FeedRepository feedRepository;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Integer feedId) {

        User user = userFacade.getCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        if (!user.equals(feed.getUser())) {
            throw NotDeleteFeedException.EXCEPTION;
        }

        feedRepository.delete(feed);
    }
}
