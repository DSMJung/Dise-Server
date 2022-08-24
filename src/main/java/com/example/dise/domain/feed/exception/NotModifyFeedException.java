package com.example.dise.domain.feed.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class NotModifyFeedException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotModifyFeedException();

    private NotModifyFeedException() {
        super(ErrorCode.NOT_MODIFY_FEED);
    }

}
