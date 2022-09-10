package com.example.dise.domain.comment.service;

import com.example.dise.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.dise.domain.comment.domain.Comment;
import com.example.dise.domain.comment.exception.NotModifyCommentException;
import com.example.dise.domain.comment.facade.CommentFacade;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UpdateCommentService {

    private final UserFacade userFacade;
    private final CommentFacade commentFacade;

    @Transactional
    public void execute(Integer commentId, UpdateCommentRequest request) {
        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentById(commentId);

        if (!user.equals(comment.getUser())) {
            throw NotModifyCommentException.EXCEPTION;
        }

        comment.modifyComment(request.getContent());
    }

}
