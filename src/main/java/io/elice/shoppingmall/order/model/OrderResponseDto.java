package io.elice.shoppingmall.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class OrderResponseDto {

    private Long orderId;

    private OrderStatus orderStatus;

    private int orderTotalPrice;

    private String orderRequest;

    private String orderSummaryTitle;

    private List<OrderItem> orderItems = new ArrayList<>();

    private OrderDelivery orderDelivery;

}
