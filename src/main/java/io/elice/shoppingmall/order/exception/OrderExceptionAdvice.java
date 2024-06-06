package io.elice.shoppingmall.order.exception;

<<<<<<< HEAD
=======
import lombok.RequiredArgsConstructor;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

<<<<<<< HEAD
@RestControllerAdvice
public class OrderExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity<NoOrdersException> exceptionHandle(NoOrdersException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<OrderNotFoundException> exceptionHandle(OrderNotFoundException e) {
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
=======
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
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    }
}
