package io.elice.shoppingmall.order.model.dto;

import io.elice.shoppingmall.book.model.Entity.Book;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

        @Min(1)
        private int orderItemQuantity;

        @Min(1)
        private int bookId;

        private Book book;
}
