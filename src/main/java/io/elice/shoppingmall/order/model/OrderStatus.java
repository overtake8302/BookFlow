package io.elice.shoppingmall.order.model;

import lombok.Getter;

@Getter
public enum OrderStatus {
    PAYMENT_COMPLETED,
    SHIPPING,
    DELIVERED,
    PREPARING_PRODUCT;
}
