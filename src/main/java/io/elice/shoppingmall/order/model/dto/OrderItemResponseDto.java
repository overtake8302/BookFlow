package io.elice.shoppingmall.order.model.dto;

<<<<<<< HEAD
import io.elice.shoppingmall.book.model.Entity.Book;
=======
import io.elice.shoppingmall.book.model.Book;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
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
