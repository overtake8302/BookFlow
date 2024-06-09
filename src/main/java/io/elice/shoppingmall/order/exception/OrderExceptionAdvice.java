package io.elice.shoppingmall.order.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.print.DocFlavor;

@RestControllerAdvice
@RequiredArgsConstructor
public class OrderExceptionAdvice {

    private OrderExceptionMapper mapper;

    @ExceptionHandler
    public ResponseEntity<OrderExceptionResponseDto> exceptionHandle(NoOrdersException e) {
        return new ResponseEntity<>(mapper.noOrdersExceptionToOrderExceptionResponseDto(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderExceptionResponseDto> exceptionHandle(OrderNotFoundException e) {
        return new ResponseEntity<>(mapper.orderNotFoundExceptionToORderExceptionResponseDto(e), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderExceptionResponseDto> exceptionHandle(OrderAccessdeniedException e) {
        return new ResponseEntity<>(mapper.orderAccessDeniedExceptionToOrderExceptionResponseDto(e), HttpStatus.BAD_REQUEST);
    }
}
