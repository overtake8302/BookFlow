package io.elice.shoppingmall.order.model;

import io.elice.shoppingmall.audit.BaseEntity;
import jakarta.persistence.*;

@Entity
public class OrderDelivery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderDeliveryId;

    private String orderDeliveryReceiverName;
    private String orderDeliveryReceiverPhoneNumber;
    private String orderDeliveryPostalCode;
    private String orderDeliveryAddress1;
    private String orderDeliveryAddress2;
    private boolean isDeleted;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
