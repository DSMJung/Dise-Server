package com.example.dise.global.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorCode {

    PASSWORD_MISS_MATCH(401, "비밀번호가 일치하지 않습니다."),
    NOT_DELETE_COMMENT(401, "댓글을 삭제할 수 없습니다."),
    NOT_MODIFY_COMMENT(401, "댓글을 수정할 수 없습니다"),
    EXPIRED_JWT(401, "토큰이 만료되었습니다."),
    INVALID_JWT(401, "토큰이 유효하지 않습니다."),

    ID_NOT_FOUND(404, "계정를 찾을 수 없습니다."),
    USER_NOT_FOUND(404,"유저를 찾을 수 없습니다."),
    FEED_NOT_FOUND(404,"게시물을 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(404, "댓글을 찾을 수 없습니다."),

    ALREADY_USER_EXIST(409,"이미 존재하는 계정 입니다."),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");


    private final int status;
    private final String message;
}
