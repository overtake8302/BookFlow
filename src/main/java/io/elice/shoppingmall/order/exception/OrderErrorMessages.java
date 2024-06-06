package io.elice.shoppingmall.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum OrderErrorMessages {

<<<<<<< HEAD
    NO_ORDERS_FOUND("주문 내역이 없습니다.");
=======
    NO_ORDERS_FOUND("주문 내역이 없습니다."),
    ACCESS_DENIED("잘못된 요청입니다.");
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

    private String message;
}
