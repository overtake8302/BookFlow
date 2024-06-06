package io.elice.shoppingmall.order.repository;

import io.elice.shoppingmall.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

<<<<<<< HEAD
    Optional<Order> findByUserUserIdAndIsDeletedFalse(Long userId);
=======
    Optional<Order> findByUserIdAndIsDeletedFalse(Long id);
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

    Optional<Order> findByOrderIdAndIsDeletedFalse(long orderId);


    //테스트용
    List<Order> findAllByIsDeletedFalse();
<<<<<<< HEAD
=======

    Optional<List<Order>> findAllByUserIdAndIsDeletedFalse(Long id);
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
}
