package io.elice.shoppingmall.order.model;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderItemDto {

        @Min(1)
        private int orderItemQuantity;

        @Min(1)
        private int bookId;


}
