package io.elice.shoppingmall.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrdersResponseDto {

    List<OrderResponseCombinedDto> orderList = new ArrayList<>();
}
