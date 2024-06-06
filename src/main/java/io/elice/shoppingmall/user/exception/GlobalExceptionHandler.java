package io.elice.shoppingmall.user.exception;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity userNotFoundException(HttpServletResponse response, UserNotFoundException ex) {
        log.error("전역 핸들러 - message: {}", ex.getErrorCode().getDetailMessage());
        return null;
    }

}
