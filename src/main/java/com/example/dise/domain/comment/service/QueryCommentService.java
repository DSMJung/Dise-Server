package com.example.dise.domain.comment.service;

import com.example.dise.domain.comment.controller.dto.response.CommentElement;
import com.example.dise.domain.comment.controller.dto.response.CommentListResponse;
import com.example.dise.domain.comment.domain.Comment;
import com.example.dise.domain.comment.domain.repository.CommentRepository;
import com.example.dise.domain.feed.domain.Feed;
import com.example.dise.domain.feed.facade.FeedFacade;
import com.example.dise.domain.user.exception.UserNotFoundException;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryCommentService {

    private final FeedFacade feedFacade;
    private final CommentRepository commentRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public CommentListResponse execute(Integer feedId) {
        Feed feed = feedFacade.getFeedById(feedId);

        List<CommentElement> commentList = commentRepository.findAllByFeedId(feed.getId())
                .stream()
                .map(this::buildCommentList)
                .collect(Collectors.toList());

        return new CommentListResponse(commentList);
    }

    private CommentElement buildCommentList(Comment comment) {
        Integer userId = comment.getUserId();

        return CommentElement.builder()
                .commentId(comment.getId())
                .content(comment.getContent())
                .name(comment.getUserName())
                .isMine(getIsMine(userId))
                .build();
    }
    private boolean getIsMine(Integer userId) {
        try {
            return userFacade.getUserId().equals(userId);
        } catch (UserNotFoundException e) {
            return false;
        }
    }
}
