package io.elice.shoppingmall.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class NoOrdersException extends RuntimeException {

    private OrderErrorMessages orderErrorMessages;
}
