package io.elice.shoppingmall.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoOrdersException extends RuntimeException {

    private OrderErrorMessages orderErrorMessages;

    public NoOrdersException(OrderErrorMessages messages) {
        super(messages.getMessage());
        this.orderErrorMessages = messages;
    }
}
