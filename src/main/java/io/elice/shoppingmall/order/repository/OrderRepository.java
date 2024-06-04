package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByUserUserIdAndIsDeletedFalse(Long userId);

    Optional<Order> findByOrderIdAndIsDeletedFalse(long orderId);


    //테스트용
    List<Order> findAllByIsDeletedFalse();
}
