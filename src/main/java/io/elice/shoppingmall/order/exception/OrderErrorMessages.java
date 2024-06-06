package io.elice.shoppingmall.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum OrderErrorMessages {

    NO_ORDERS_FOUND("주문 내역이 없습니다.");

    private String message;
}
