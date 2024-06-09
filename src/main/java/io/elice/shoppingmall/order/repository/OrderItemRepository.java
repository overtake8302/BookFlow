package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findByOrderItemIdAndIsDeletedFalse(Long id);
}
