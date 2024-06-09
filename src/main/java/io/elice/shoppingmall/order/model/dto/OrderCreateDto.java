package io.elice.shoppingmall.order.model.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateDto {

//    @Min(1)
//    private int orderTotalPrice;

//    private String orderRequest;

    @NotNull
    private OrderDto orderDto;

    @NotNull
    private OrderDeliveryDto orderDeliveryDto;

    @NotEmpty
    private List<OrderItemDto> orderItemDtos = new ArrayList<>();

}
