package io.elice.shoppingmall.user.exception;

public class UserNotFoundException extends RootException{
    private String description;

    public UserNotFoundException(String description) {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
