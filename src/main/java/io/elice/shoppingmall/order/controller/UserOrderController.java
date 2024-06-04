package io.elice.shoppingmall.order.controller;


import io.elice.shoppingmall.order.model.*;
import io.elice.shoppingmall.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserOrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    @GetMapping("/orders")
    public ResponseEntity<OrderResponseDto> getOrders() {
        Order order = orderService.findOrders();
        OrderResponseDto orderResponseDto = orderMapper.orderToOrderResponseDto(order);

        return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity postOrder(@RequestBody @Validated OrderCreateDto orderCreateDto, BindingResult error) {

        if (error.hasErrors()) {
            return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
        }

        Order requestOrder = orderMapper.orderCreateDtoToOrder(orderCreateDto);
        OrderDelivery requestOrderDelivery = orderMapper.orderCreateDtoToOrderDelivery(orderCreateDto);
        List<OrderItem> requestOrderItems = orderMapper.orderCreateDtoToOrderItems(orderCreateDto);

        Order createdOrder = orderService.creatOrder(requestOrder, requestOrderDelivery, requestOrderItems);

        OrderResponseDto orderResponseDto = orderMapper.orderToOrderResponseDto(createdOrder);
        return new ResponseEntity(orderResponseDto, HttpStatus.CREATED);

    }
}
