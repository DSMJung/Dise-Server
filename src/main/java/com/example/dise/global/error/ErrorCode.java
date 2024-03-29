package com.example.dise.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    EXPIRED_JWT(401, "토큰이 만료되었습니다."),
    INVALID_JWT(401, "토큰이 유효하지 않습니다."),
    NOT_MODIFY_FEED(401, "게시글을 수정할 수 없습니다."),
    NOT_DELETE_FEED(401, "게시글을 삭제할 수 없습니다."),
    NOT_MODIFY_COMMENT(401, "댓글을 수정할 수 없습니다."),
    NOT_DELETE_COMMENT(401, "댓글을 삭제할 수 없습니다."),

    PASSWORD_MISMATCH(401, "비밀번호가 불일치합니다."),

    ACCOUNT_ID_NOT_FOUND(404, "아이디를 찾을 수 없습니다."),
    USER_NOT_FOUND(404, "유저를 찾을 수 없습니다."),
    FEED_NOT_FOUND(404, "게시물을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(404, "댓글을 찾을 수 없습니다."),

    ALREADY_USER_EXIST(409, "이미 존재하는 유저 입니다."),

    INTERNAL_SERVER_ERROR(500, "내부 서버 오류입니다.");

    private final int status;
    private final String message;
}
