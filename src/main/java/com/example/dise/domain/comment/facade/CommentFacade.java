package com.example.dise.domain.comment.facade;

import com.example.dise.domain.comment.domain.Comment;
import com.example.dise.domain.comment.domain.repository.CommentRepository;
import com.example.dise.domain.comment.exception.CommentNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {

    private final CommentRepository commentRepository;

    public Comment getCommentById(Integer commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> CommentNotFoundException.EXCEPTION);
    }

}
