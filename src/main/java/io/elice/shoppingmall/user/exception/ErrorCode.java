package io.elice.shoppingmall.user.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    USER_NOT_FOUND(400, "UserNotFoundException", "사용자를 찾을 수 없습니다.");

    private final int status;
    private final String message;
    private final String detailMessage;

    ErrorCode(int status, String message, String detailMessage) {
        this.status = status;
        this.message = message;
        this.detailMessage = detailMessage;
    }
}
