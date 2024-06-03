package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
