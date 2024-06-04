package io.elice.shoppingmall.order.model.dto;

import io.elice.shoppingmall.book.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDto {

    private int orderItemPrice;

    private int orderItemTotalPrice;

    private int orderItemQuantity;

    private Book book;
}
