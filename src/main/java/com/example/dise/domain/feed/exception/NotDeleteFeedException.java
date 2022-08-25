package com.example.dise.domain.feed.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class NotDeleteFeedException extends CustomException {

    public static final CustomException EXCEPTION =
            new NotDeleteFeedException();

    private NotDeleteFeedException() {
        super(ErrorCode.NOT_DELETE_FEED);
    }
}
