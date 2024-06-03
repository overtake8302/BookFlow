package io.elice.shoppingmall.order.service;


import io.elice.shoppingmall.order.repository.OrderDeliveryRepository;
import io.elice.shoppingmall.order.repository.OrderItemRepository;
import io.elice.shoppingmall.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderDeliveryRepository orderDeliveryRepository;


}
