package io.elice.shoppingmall.order.model.dto;

import io.elice.shoppingmall.order.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusDto {

    private OrderStatus orderStatus;
}
