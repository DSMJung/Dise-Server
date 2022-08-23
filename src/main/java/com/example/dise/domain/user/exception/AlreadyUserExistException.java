package com.example.dise.domain.user.exception;

import com.example.dise.global.error.CustomException;
import com.example.dise.global.error.ErrorCode;

public class AlreadyUserExistException extends CustomException {

    public static final CustomException EXCEPTION =
            new AlreadyUserExistException();

    private AlreadyUserExistException() {
        super(ErrorCode.ALREADY_USER_EXIST);
    }
}
