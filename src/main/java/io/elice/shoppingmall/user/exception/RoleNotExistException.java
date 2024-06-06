package io.elice.shoppingmall.user.exception;

public class RoleNotExistException extends RootException{
    private String description;

    public RoleNotExistException(String description) {
        super(ErrorCode.ROLE_NOT_EXIST);
    }
}
