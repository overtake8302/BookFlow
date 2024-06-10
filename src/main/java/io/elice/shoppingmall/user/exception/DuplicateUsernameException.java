package io.elice.shoppingmall.user.exception;

public class DuplicateUsernameException extends RootException{
    private String description;

    public DuplicateUsernameException(String description) {
        super(ErrorCode.USERNAME_DUPLICATE);
    }
}
