package com.example.dise.domain.comment.controller;

import com.example.dise.domain.comment.controller.dto.request.CreateCommentRequest;
import com.example.dise.domain.comment.service.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CreateCommentService commentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void createComment(@PathVariable("feed-id") Integer id,
                              @RequestBody @Valid CreateCommentRequest request) {
        commentService.execute(id, request);
    }
}
