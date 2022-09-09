package com.example.dise.domain.comment.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class NotModifyCommentException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotModifyCommentException();

    private NotModifyCommentException() {
        super(ErrorCode.NOT_MODIFY_COMMENT);
    }

}
