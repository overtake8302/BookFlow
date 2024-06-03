package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {


}
