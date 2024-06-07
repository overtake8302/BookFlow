package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.OrderDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderDeliveryRepository extends JpaRepository<OrderDelivery, Long> {

    Optional<OrderDelivery> findByOrderDeliveryIdAndIsDeletedFalse(Long id);

}
