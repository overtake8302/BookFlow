package io.elice.shoppingmall.order.model;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderCreateDto {

    @Min(1)
    private int orderTotalPrice;

    private String orderRequest;

    @NotBlank
    private String orderDeliveryReceiverName;

    @NotBlank
    private String orderDeliveryReceiverPhoneNumber;

    @NotBlank
    private String orderDeliveryPostalCode;

    @NotBlank
    private String orderDeliveryAddress1;

    @NotBlank
    private String orderDeliveryAddress2;

    @NotEmpty
    List<OrderItemDto> orderItemDtos = new ArrayList<>();

}
