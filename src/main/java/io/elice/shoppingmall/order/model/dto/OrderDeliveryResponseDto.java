package io.elice.shoppingmall.order.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeliveryResponseDto {

    private String orderDeliveryReceiverName;

    private String orderDeliveryReceiverPhoneNumber;

    private String orderDeliveryPostalCode;

    private String orderDeliveryAddress1;

    private String orderDeliveryAddress2;
}
