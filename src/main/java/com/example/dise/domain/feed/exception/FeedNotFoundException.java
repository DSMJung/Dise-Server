package com.example.dise.domain.feed.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class FeedNotFoundException extends CustomException {

    public static final CustomException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(ErrorCode.FEED_NOT_FOUND);
    }

}
