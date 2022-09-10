package com.example.dise.domain.comment.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class NotDeleteCommentException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotDeleteCommentException();

    private NotDeleteCommentException() {
        super(ErrorCode.NOT_DELETE_COMMENT);
    }
}
