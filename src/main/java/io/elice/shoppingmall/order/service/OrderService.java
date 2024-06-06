package io.elice.shoppingmall.order.service;


import io.elice.shoppingmall.order.exception.NoOrdersException;
<<<<<<< HEAD
=======
import io.elice.shoppingmall.order.exception.OrderAccessdeniedException;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import io.elice.shoppingmall.order.exception.OrderErrorMessages;
import io.elice.shoppingmall.order.exception.OrderNotFoundException;
import io.elice.shoppingmall.order.model.*;
import io.elice.shoppingmall.order.model.dto.OrderCreateDto;
<<<<<<< HEAD
import io.elice.shoppingmall.order.repository.OrderDeliveryRepository;
import io.elice.shoppingmall.order.repository.OrderItemRepository;
import io.elice.shoppingmall.order.repository.OrderRepository;
=======
import io.elice.shoppingmall.order.model.dto.OrderStatusDto;
import io.elice.shoppingmall.order.repository.OrderDeliveryRepository;
import io.elice.shoppingmall.order.repository.OrderItemRepository;
import io.elice.shoppingmall.order.repository.OrderRepository;
import io.elice.shoppingmall.user.model.User;
import io.elice.shoppingmall.user.repository.AuthRepository;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import java.util.List;
=======
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Objects;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final OrderDeliveryRepository orderDeliveryRepository;
    private final OrderMapper orderMapper;
<<<<<<< HEAD
//    private final UserService userService;
=======
    private final AuthRepository authRepository;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

    private String getCurrentUsername() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

<<<<<<< HEAD
    /*private User getCurrentUser() {

        User currentUser = userService.findUser(getCurrentUsername());
        return currentUser;
    }*/
=======
    private User getCurrentUser() {

        User currentUser = authRepository.findByUsername(getCurrentUsername());
        return currentUser;
    }
>>>>>>> 3bd465834f53b723681605371ce84809a3467005


   @Transactional
    public Order creatOrder(Order requestOrder, OrderDelivery requestOrderDelivery, List<OrderItem> requestOrderItems) {

<<<<<<< HEAD
        /*User currentUser = getCurrentUser();
        requestOrder.setUser(currentUser);*/
=======
        User currentUser = getCurrentUser();
        requestOrder.setUser(currentUser);
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

        Order savedOrder = orderRepository.save(requestOrder);
        savedOrder.setOrderStatus(OrderStatus.PAYMENT_COMPLETED);

<<<<<<< HEAD
//        requestOrderDelivery.setOrder(savedOrder);
=======
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
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

<<<<<<< HEAD
       /*User currentUser = getCurrentUser();
       Optional<List<Order>> orders = orderRepository.findByUserUserIdAndIsDeletedFalse(currentUser.getId());*/

        //테스트용 임시

        List<Order> orders = orderRepository.findAllByIsDeletedFalse();



=======
       User currentUser = getCurrentUser();
       Optional<List<Order>> orders = orderRepository.findAllByUserIdAndIsDeletedFalse(currentUser.getId());
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

       if (orders.isEmpty()) {
           throw new NoOrdersException(OrderErrorMessages.NO_ORDERS_FOUND);
       }

<<<<<<< HEAD
       //테스트용 임시
        return orders;

//       return orders.get();
=======
       return orders.get();
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    }

    public Order findOrder(Long id) {

<<<<<<< HEAD
=======
       Long currentUserId = getCurrentUser().getId();
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
       Optional<Order> foundOrder = orderRepository.findByOrderIdAndIsDeletedFalse(id);

       if (foundOrder.isEmpty()) {
           throw new OrderNotFoundException(OrderErrorMessages.NO_ORDERS_FOUND);
       }

<<<<<<< HEAD
=======
       Long foundOrderUserId = foundOrder.get().getUser().getId();

       if (!Objects.equals(currentUserId, foundOrderUserId)) {
           throw new OrderAccessdeniedException(OrderErrorMessages.ACCESS_DENIED);
       }

>>>>>>> 3bd465834f53b723681605371ce84809a3467005
       return foundOrder.get();
    }

    @Transactional
    public void deleteOrder(Long orderId) {

<<<<<<< HEAD
       Order foundOrder = findOrder(orderId);

=======
        Long currentUserId = getCurrentUser().getId();

       Order foundOrder = findOrder(orderId);

       Long foundOrderUserId = foundOrder.getUser().getId();

       if (!Objects.equals(currentUserId, foundOrderUserId)) {
           throw new OrderAccessdeniedException(OrderErrorMessages.ACCESS_DENIED);
       }

       OrderStatus status = foundOrder.getOrderStatus();

       if (status.equals(OrderStatus.SHIPPING) || status.equals(OrderStatus.DELIVERED)) {
           throw new OrderAccessdeniedException(OrderErrorMessages.ACCESS_DENIED);
       }

>>>>>>> 3bd465834f53b723681605371ce84809a3467005
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

<<<<<<< HEAD
=======
       Long currentUserId = getCurrentUser().getId();
       Long oldOrderUserId = oldOrder.getUser().getId();

       if (!Objects.equals(currentUserId, oldOrderUserId)) {
           throw new OrderAccessdeniedException(OrderErrorMessages.ACCESS_DENIED);
       }

       OrderStatus status = oldOrder.getOrderStatus();

       if (status.equals(OrderStatus.DELIVERED) || status.equals(OrderStatus.SHIPPING)) {
           throw new OrderAccessdeniedException(OrderErrorMessages.ACCESS_DENIED);
       }
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

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
<<<<<<< HEAD
=======

    public List<Order> findOrdersByAdmin() {

        List<Order> orders = orderRepository.findAllByIsDeletedFalse();

        if (orders.isEmpty()) {
            throw new NoOrdersException(OrderErrorMessages.NO_ORDERS_FOUND);
        }

        return orders;
    }

    public Order findOrderByAdmin(Long id) {

        Optional<Order> foundOrder = orderRepository.findByOrderIdAndIsDeletedFalse(id);

        if (foundOrder.isEmpty()) {
            throw new OrderNotFoundException(OrderErrorMessages.NO_ORDERS_FOUND);
        }

        return foundOrder.get();
    }

    @Transactional
    public void deleteOrderByAdmin(Long orderId) {

        Order foundOrder = findOrder(orderId);

        foundOrder.setDeleted(true);
        foundOrder.getOrderDelivery().setDeleted(true);
        for (OrderItem item : foundOrder.getOrderItems()) {
            item.setDeleted(true);
        }

        orderRepository.save(foundOrder);
    }

    @Transactional
    public void editOrderStatusByAdmin(Long orderId, OrderStatus orderStatus) {

        Order foundOrder = findOrderByAdmin(orderId);
        foundOrder.setOrderStatus(orderStatus);
    }
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
}
