package io.elice.shoppingmall.user.exception;

import lombok.Getter;

@Getter
public class RootException extends RuntimeException {
    private boolean isSuccess;
    private ErrorCode errorCode;

    public RootException(ErrorCode errorCode) {
        super(errorCode.getDetailMessage());
        this.isSuccess = false;
        this.errorCode = errorCode;
    }
}
