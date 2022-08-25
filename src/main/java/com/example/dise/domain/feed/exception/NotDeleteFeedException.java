package com.example.dise.domain.feed.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class NotDeleteFeedException extends CustomException {

    public static final NotDeleteFeedException EXCEPTION =
            new NotDeleteFeedException();

    private NotDeleteFeedException() {
        super(ErrorCode.NOY_DELETE_FEED);
    }
}
