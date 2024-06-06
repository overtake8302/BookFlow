package io.elice.shoppingmall.user.exception;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity userNotFoundException(HttpServletResponse response, UserNotExistException ex) {
        log.error("message: {}", ex.getErrorCode().getDetailMessage());
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RoleNotExistException.class)
    public ResponseEntity roleNotExistException(HttpServletResponse response, RoleNotExistException ex) {
        log.error("message: {}", ex.getErrorCode().getDetailMessage());
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DuplicateUsernameException.class)
    public ResponseEntity duplicateUsernameException(HttpServletResponse response, DuplicateUsernameException ex) {
        log.error("message: {}", ex.getErrorCode().getDetailMessage());
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }
}
