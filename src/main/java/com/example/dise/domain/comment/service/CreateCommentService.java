package com.example.dise.domain.comment.service;

import com.example.dise.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.dise.domain.comment.domain.Comment;
import com.example.dise.domain.comment.domain.repository.CommentRepository;
import com.example.dise.domain.feed.facade.FeedFacade;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateCommentService {
    private final FeedFacade feedFacade;
    private final UserFacade userFacade;
    private final CommentRepository commentRepository;

    public void execute(Integer id, CreateCommentRequest request) {
        commentRepository.save(
                Comment.builder()
                        .content(request.getContent())
                        .user(userFacade.getCurrentUser())
                        .feed(feedFacade.getFeedById(id))
                        .build());
    }
}
