package io.elice.shoppingmall.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    PAYMENT_COMPLETED,
    SHIPPING,
    DELIVERED,
    PREPARING_PRODUCT;
}
