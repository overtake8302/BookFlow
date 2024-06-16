package io.elice.shoppingmall.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdersPageDto {

    private OrdersResponseDto ordersResponseDto;
    private int number;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean last;
}
