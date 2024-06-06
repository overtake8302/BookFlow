package io.elice.shoppingmall.order.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class OrderExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<NoOrdersException> exceptionHandle(NoOrdersException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderNotFoundException> exceptionHandle(OrderNotFoundException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
