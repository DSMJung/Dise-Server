package com.example.dise.domain.feed.facade;

import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.domain.repository.FeedRepository;
import com.example.dise.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeedFacade {

    private final FeedRepository feedRepository;

    public Feed getFeedById(Integer id) {
        return feedRepository.findById(id)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
