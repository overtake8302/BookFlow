package io.elice.shoppingmall.order.service;


import io.elice.shoppingmall.order.exception.NoOrdersException;
import io.elice.shoppingmall.order.exception.OrderErrorMessages;
import io.elice.shoppingmall.order.exception.OrderExceptionAdvice;
import io.elice.shoppingmall.order.model.Order;
import io.elice.shoppingmall.order.model.OrderDelivery;
import io.elice.shoppingmall.order.model.OrderItem;
import io.elice.shoppingmall.order.model.OrderStatus;
import io.elice.shoppingmall.order.repository.OrderDeliveryRepository;
import io.elice.shoppingmall.order.repository.OrderItemRepository;
import io.elice.shoppingmall.order.repository.OrderRepository;
import io.elice.shoppingmall.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderDeliveryRepository orderDeliveryRepository;
//    private final UserService userService;

    public String getCurrentUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

/*    public User getCurrentUser() {

        User currentUser = userService.findUser(getCurrentUsername());
        return currentUser;
    }*/


   @Transactional
    public Order creatOrder(Order requestOrder, OrderDelivery requestOrderDelivery, List<OrderItem> requestOrderItems) {

        /*User currentUser = getCurrentUser();
        requestOrder.setUser(currentUser);*/

        Order savedOrder = orderRepository.save(requestOrder);
        savedOrder.setOrderStatus(OrderStatus.PAYMENT_COMPLETED);

        requestOrderDelivery.setOrder(savedOrder);
        orderDeliveryRepository.save(requestOrderDelivery);

        int orderTotalPrice = 0;

        for (OrderItem orderItem : requestOrderItems) {

            orderItem.setOrder(savedOrder);
//            orderItem.setOrderItemPrice(orderItem.getBook().getPrice());
            //테스트용 임시 가격
            orderItem.setOrderItemPrice(10000);

            int totalPrice = orderItem.getOrderItemPrice() + orderItem.getOrderItemQuantity();
            orderItem.setOrderItemTotalPrice(totalPrice);
            orderTotalPrice += totalPrice;
        }

        List<OrderItem> savedOrderItems = orderItemRepository.saveAll(requestOrderItems);

        savedOrder.setOrderTotalPrice(orderTotalPrice);

        /*String orderSummaryTitle = savedOrderItems.get(0).getBook().getName();

        int itemsCount = savedOrderItems.size();
        if (itemsCount > 1) {
            orderSummaryTitle += "외 " + (itemsCount - 1) + " 건";
        }*/

       savedOrder.setOrderSummaryTitle("테스트");

       savedOrder = orderRepository.save(savedOrder);

        return savedOrder;
    }

    public Order findOrders() {

/*       User currentUser = getCurrentUser();
       Optional<Order> orders = orderRepository.findById(currentUser.getUserId());*/

        //테스트용 임시
        Optional<Order> orders = orderRepository.findById(123L);


       if (orders.isEmpty()) {
           throw new NoOrdersException(OrderErrorMessages.NO_ORDERS_FOUND);
       }

       return orders.get();
    }
}
