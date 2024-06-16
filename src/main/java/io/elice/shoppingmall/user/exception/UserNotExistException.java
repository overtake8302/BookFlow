package io.elice.shoppingmall.user.exception;

public class UserNotExistException extends RootException{
    private String description;

    public UserNotExistException(String description) {
        super(ErrorCode.USER_NOT_EXIST);
    }
}
