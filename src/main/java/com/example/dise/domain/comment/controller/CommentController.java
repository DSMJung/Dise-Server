package com.example.dise.domain.comment.controller;

import com.example.dise.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.dise.domain.comment.controller.dto.request.UpdateCommentRequest;
import com.example.dise.domain.comment.controller.dto.response.CommentListResponse;
import com.example.dise.domain.comment.service.CreateCommentService;
import com.example.dise.domain.comment.service.DeleteCommentService;
import com.example.dise.domain.comment.service.QueryCommentService;
import com.example.dise.domain.comment.service.UpdateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CreateCommentService commentService;
    private final QueryCommentService queryCommentService;
    private final UpdateCommentService updateCommentService;
    private final DeleteCommentService deleteCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void createComment(@PathVariable("feed-id") Integer id,
                              @RequestBody @Valid CreateCommentRequest request) {
        commentService.execute(id, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{comment-id}")
    public void modifyComment(@PathVariable("comment-id") Integer commentId,
                              @RequestBody @Valid UpdateCommentRequest request) {
        updateCommentService.execute(commentId, request);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id") Integer commentId) {
        deleteCommentService.execute(commentId);
    }

    @GetMapping("/{feed-id}")
    public CommentListResponse getComment(@PathVariable("feed-id") Integer feedId) {
        return queryCommentService.execute(feedId);
    }

}
