package io.elice.shoppingmall.order.model.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeliveryDto {

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
}
