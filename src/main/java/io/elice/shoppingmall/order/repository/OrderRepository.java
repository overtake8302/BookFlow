package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

//    Optional<Order> findByUserIdAndIsDeletedFalse(Long id);

    Optional<Order> findByOrderIdAndIsDeletedFalse(long orderId);


    //테스트용
    List<Order> findAllByIsDeletedFalse();

    Page<Order> findAllByUserIdAndIsDeletedFalse(Long id, Pageable pageable);
}
