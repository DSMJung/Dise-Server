package com.example.dise.domain.feed.service;

import com.example.dise.domain.feed.controller.dto.request.CreateFeedRequest;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createFeed(CreateFeedRequest request) {
        User user = userFacade.getCurrentUser();

        feedRepository.save(Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .category(request.getCategory())
                .user(user)
                .build());
    }
}
