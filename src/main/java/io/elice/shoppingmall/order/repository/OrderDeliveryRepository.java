package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.OrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, Long> {

}
