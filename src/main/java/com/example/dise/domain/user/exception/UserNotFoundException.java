package com.example.dise.domain.user.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class UserNotFoundException extends CustomException {
    public static final CustomException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
