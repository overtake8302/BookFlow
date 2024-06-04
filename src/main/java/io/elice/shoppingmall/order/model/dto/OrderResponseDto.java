package io.elice.shoppingmall.order.model.dto;

import io.elice.shoppingmall.order.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Long orderId;

    private OrderStatus orderStatus;

    private int orderTotalPrice;

    private String orderRequest;

    private String orderSummaryTitle;



}
