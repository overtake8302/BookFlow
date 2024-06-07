package io.elice.shoppingmall.order.controller;

import io.elice.shoppingmall.order.model.Order;
import io.elice.shoppingmall.order.model.OrderMapper;
import io.elice.shoppingmall.order.model.OrderStatus;
import io.elice.shoppingmall.order.model.dto.OrderResponseCombinedDto;
import io.elice.shoppingmall.order.model.dto.OrderStatusDto;
import io.elice.shoppingmall.order.model.dto.OrdersResponseDto;
import io.elice.shoppingmall.order.repository.OrderRepository;
import io.elice.shoppingmall.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminOrderController {

    private final OrderService orderService;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @GetMapping("/orders")
    public ResponseEntity<OrdersResponseDto> getOrdersByAdmin() {

        List<Order> foundOrders = orderService.findOrdersByAdmin();
        OrdersResponseDto orders = orderMapper.ordersToOrdersResponseDto(foundOrders);

        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<OrderResponseCombinedDto> getOrderByAdmin(@PathVariable Long orderId) {

        Order foundOrder = orderService.findOrderByAdmin(orderId);
        OrderResponseCombinedDto orderResponseCombinedDto = orderMapper.orderToOrderResponseCombinedDto(foundOrder);

        return new ResponseEntity<>(orderResponseCombinedDto, HttpStatus.OK);
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<HttpStatus> deleteOrderByAdmin(@PathVariable Long orderId) {

        orderService.deleteOrderByAdmin(orderId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<HttpStatus> putOrderStatusByAdmin(@PathVariable Long orderId, @RequestBody OrderStatusDto orderStatusDto) {

        OrderStatus orderStatus = orderStatusDto.getOrderStatus();

        orderService.editOrderStatusByAdmin(orderId, orderStatus);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
