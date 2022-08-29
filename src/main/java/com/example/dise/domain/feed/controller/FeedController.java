package com.example.dise.domain.feed.controller;

import com.example.dise.domain.feed.controller.dto.request.CreateFeedRequest;
import com.example.dise.domain.feed.controller.dto.request.UpdateFeedRequest;
import com.example.dise.domain.feed.controller.dto.response.FeedDetailsResponse;
import com.example.dise.domain.feed.service.CreateFeedService;
import com.example.dise.domain.feed.service.DeleteFeedService;
import com.example.dise.domain.feed.service.FeedDetailsService;
import com.example.dise.domain.feed.service.UpdateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/feed")
@RestController
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;
    private final FeedDetailsService feedDetailsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.createFeed(request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{feed-id}")
    public void modifyFeed(@PathVariable("feed-id") Integer feedId,
                           @RequestBody @Valid UpdateFeedRequest request) {
        updateFeedService.modifyFeed(feedId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    public void deleteFeed(@PathVariable("feed-id") Integer feedId) {
        deleteFeedService.execute(feedId);
    }

    @GetMapping("/{feed-id}")
    public FeedDetailsResponse feedDetails(@PathVariable("feed-id") Integer feedId) {
        return feedDetailsService.execute(feedId);
    }
}
