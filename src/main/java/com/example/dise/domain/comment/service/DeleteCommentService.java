package com.example.dise.domain.comment.service;

import com.example.dise.domain.comment.domain.Comment;
import com.example.dise.domain.comment.domain.repository.CommentRepository;
import com.example.dise.domain.comment.exception.NotDeleteCommentException;
import com.example.dise.domain.comment.facade.CommentFacade;
import com.example.dise.domain.user.domain.User;
import com.example.dise.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DeleteCommentService {

    private final UserFacade userFacade;
    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Integer commentId) {

        User user = userFacade.getCurrentUser();
        Comment comment = commentFacade.getCommentById(commentId);

        if (!user.equals(comment.getUser())) {
            throw NotDeleteCommentException.EXCEPTION;
        }

        commentRepository.delete(comment);
    }
}
