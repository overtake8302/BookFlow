package io.elice.shoppingmall.order.service;


import io.elice.shoppingmall.order.exception.NoOrdersException;
import io.elice.shoppingmall.order.exception.OrderErrorMessages;
import io.elice.shoppingmall.order.exception.OrderNotFoundException;
import io.elice.shoppingmall.order.model.*;
import io.elice.shoppingmall.order.model.dto.OrderCreateDto;
import io.elice.shoppingmall.order.repository.OrderDeliveryRepository;
import io.elice.shoppingmall.order.repository.OrderItemRepository;
import io.elice.shoppingmall.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderDeliveryRepository orderDeliveryRepository;
    private final OrderMapper orderMapper;
//    private final UserService userService;

    private String getCurrentUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    /*private User getCurrentUser() {

        User currentUser = userService.findUser(getCurrentUsername());
        return currentUser;
    }*/


   @Transactional
    public Order creatOrder(Order requestOrder, OrderDelivery requestOrderDelivery, List<OrderItem> requestOrderItems) {

        /*User currentUser = getCurrentUser();
        requestOrder.setUser(currentUser);*/

        Order savedOrder = orderRepository.save(requestOrder);
        savedOrder.setOrderStatus(OrderStatus.PAYMENT_COMPLETED);

//        requestOrderDelivery.setOrder(savedOrder);
        OrderDelivery savedOrderDelivery = orderDeliveryRepository.save(requestOrderDelivery);
        savedOrder.setOrderDelivery(savedOrderDelivery);

        int orderTotalPrice = 0;

        for (OrderItem orderItem : requestOrderItems) {

            orderItem.setOrder(savedOrder);
//            orderItem.setOrderItemPrice(orderItem.getBook().getPrice());
            //테스트용 임시 가격
            orderItem.setOrderItemPrice(10000);

            int totalPrice = orderItem.getOrderItemPrice() * orderItem.getOrderItemQuantity();
            orderItem.setOrderItemTotalPrice(totalPrice);
            orderTotalPrice += totalPrice;
        }

        List<OrderItem> savedOrderItems = orderItemRepository.saveAll(requestOrderItems);
        savedOrder.setOrderTotalPrice(orderTotalPrice);
        savedOrder.setOrderItems(savedOrderItems);

        /*String orderSummaryTitle = savedOrderItems.get(0).getBook().getName();

        int itemsCount = savedOrderItems.size();
        if (itemsCount > 1) {
            orderSummaryTitle += "외 " + (itemsCount - 1) + " 건";
        }*/

       savedOrder.setOrderSummaryTitle("테스트");

       savedOrder = orderRepository.save(savedOrder);

        return savedOrder;
    }

    public List<Order> findOrders() {

       /*User currentUser = getCurrentUser();
       Optional<List<Order>> orders = orderRepository.findByUserUserIdAndIsDeletedFalse(currentUser.getId());*/

        //테스트용 임시

        List<Order> orders = orderRepository.findAllByIsDeletedFalse();




       if (orders.isEmpty()) {
           throw new NoOrdersException(OrderErrorMessages.NO_ORDERS_FOUND);
       }

       //테스트용 임시
        return orders;

//       return orders.get();
    }

    public Order findOrder(Long id) {

       Optional<Order> foundOrder = orderRepository.findByOrderIdAndIsDeletedFalse(id);

       if (foundOrder.isEmpty()) {
           throw new OrderNotFoundException(OrderErrorMessages.NO_ORDERS_FOUND);
       }

       return foundOrder.get();
    }

    @Transactional
    public void deleteOrder(Long orderId) {

       Order foundOrder = findOrder(orderId);

       foundOrder.setDeleted(true);
       foundOrder.getOrderDelivery().setDeleted(true);
       for (OrderItem item : foundOrder.getOrderItems()) {
           item.setDeleted(true);
       }

       orderRepository.save(foundOrder);
    }

    @Transactional
    public Order editOrder(Long orderId, OrderCreateDto dto) {

       Order oldOrder = findOrder(orderId);
       List<OrderItem> oldItems = oldOrder.getOrderItems();
       List<OrderItem> updateRequestOrderItems = orderMapper.orderCreateDtoToOrderItems(dto);


//       for (OrderItem newItem : updateRequestOrderItems) {
//
//           for (OrderItem oldItem : oldItems) {
//
//               boolean isMatch = newItem.getBook().getId() == oldItem.getBook().getId();
//               if (isMatch) {
//                   oldItem.setOrderItemQuantity(newItem.getOrderItemQuantity());
//                   break;
//               }
//           }
//       }

       int newOrderTotalPrice = 0;
       for (OrderItem item : oldItems) {
           int totalPrice = 0;
           totalPrice = item.getOrderItemPrice() * item.getOrderItemQuantity();
           newOrderTotalPrice += totalPrice;
           item.setOrderItemTotalPrice(totalPrice);
       }
       List<OrderItem> updatedOrderItems = orderItemRepository.saveAll(oldItems);
       oldOrder.setOrderItems(updatedOrderItems);

       OrderDelivery oldOrderDelivery = oldOrder.getOrderDelivery();
       OrderDelivery updateRequestOrderDelivery = orderMapper.orderDeliveryDtoToOrderDelivery(dto.getOrderDeliveryDto());

       oldOrderDelivery.setOrderDeliveryReceiverName(updateRequestOrderDelivery.getOrderDeliveryReceiverName());
       oldOrderDelivery.setOrderDeliveryReceiverPhoneNumber(updateRequestOrderDelivery.getOrderDeliveryReceiverPhoneNumber());
       oldOrderDelivery.setOrderDeliveryPostalCode(updateRequestOrderDelivery.getOrderDeliveryPostalCode());
       oldOrderDelivery.setOrderDeliveryAddress1(updateRequestOrderDelivery.getOrderDeliveryAddress1());
       oldOrderDelivery.setOrderDeliveryAddress2(updateRequestOrderDelivery.getOrderDeliveryAddress2());

       OrderDelivery updatedOrderDelivery = orderDeliveryRepository.save(oldOrderDelivery);
       oldOrder.setOrderDelivery(updatedOrderDelivery);

       oldOrder.setOrderRequest(dto.getOrderDto().getOrderRequest());

       Order updatedOrder = orderRepository.save(oldOrder);

       return updatedOrder;
    }
}
