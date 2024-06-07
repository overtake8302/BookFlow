package io.elice.shoppingmall.order.model;

import io.elice.shoppingmall.audit.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDelivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDeliveryId;

    @Column(nullable = false, length = 10)
    private String orderDeliveryReceiverName;

    @Column(nullable = false, length = 20)
    private String orderDeliveryReceiverPhoneNumber;

    @Column(nullable = false, length = 10)
    private String orderDeliveryPostalCode;

    @Column(nullable = false, length = 50)
    private String orderDeliveryAddress1;

    @Column(nullable = false, length = 50)
    private String orderDeliveryAddress2;

    private boolean isDeleted;


}
