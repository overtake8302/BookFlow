package io.elice.shoppingmall.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
<<<<<<< HEAD
=======
import lombok.NoArgsConstructor;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PAYMENT_COMPLETED,
    SHIPPING,
    DELIVERED,
    PREPARING_PRODUCT;
}
