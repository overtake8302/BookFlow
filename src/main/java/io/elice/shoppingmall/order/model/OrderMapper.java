package io.elice.shoppingmall.order.model;

import io.elice.shoppingmall.order.model.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    /*@Autowired
    BookService bookservice;*/
    /*Order orderCreateDtoToOrder(OrderCreateDto orderCreateDto);
    OrderDelivery orderCreateDtoToOrderDelivery(OrderCreateDto orderCreateDto);*/
    Order orderDtoToOrder(OrderDto orderDto);
    OrderDelivery orderDeliveryDtoToOrderDelivery(OrderDeliveryDto orderDeliveryDto);
    OrderItemResponseDto orderItemToOrderItemResponseDto(OrderItem orderItem);
    OrderDeliveryResponseDto orderDeliveryToOrderDeliveryResponseDto(OrderDelivery orderDelivery);
    OrderResponseDto orderToOrderResponseDto(Order order);

    default OrderResponseCombinedDto orderToOrderResponseCombinedDto(Order order) {

        if (order == null ) {
            return null;
        }

        OrderResponseCombinedDto orderResponseCombinedDto = new OrderResponseCombinedDto();

        orderResponseCombinedDto.setOrder(orderToOrderResponseDto(order));
        orderResponseCombinedDto.setOrderDelivery(orderDeliveryToOrderDeliveryResponseDto(order.getOrderDelivery()));

        List<OrderItemResponseDto> orderItemResponseDtos = new ArrayList<>();
        List<OrderItem> items = order.getOrderItems();
        for (OrderItem item : items) {

            orderItemResponseDtos.add(orderItemToOrderItemResponseDto(item));
        }
        orderResponseCombinedDto.setOrderItems(orderItemResponseDtos);

        return orderResponseCombinedDto;

    }



    default List<OrderItem> orderCreateDtoToOrderItems(OrderCreateDto orderCreateDto) {

        List<OrderItem> orderItems = new ArrayList<>();
        List<OrderItemDto> orderItemDtos = orderCreateDto.getOrderItemDtos();

        for (OrderItemDto dto : orderItemDtos) {

            OrderItem orderItem = new OrderItem();
            /*Book book = bookservice.getBook(dto.getBookId());

            orderItem.setBook(book);*/
            orderItem.setOrderItemQuantity(dto.getOrderItemQuantity());

            orderItems.add(orderItem);
        }

        return orderItems;
    }

    default OrdersResponseDto ordersToOrdersResponseDto(List<Order> orders) {
        OrdersResponseDto ordersResponseDto = new OrdersResponseDto();

        for (Order order : orders) {
            ordersResponseDto.getOrderList().add(orderToOrderResponseCombinedDto(order));
        }

        return ordersResponseDto;
    }

    default OrdersPageDto pageToOrdersPageDto(Page<Order> orders) {

        OrdersPageDto ordersPageDto = new OrdersPageDto();

        ordersPageDto.setTotalPages(orders.getTotalPages());
        ordersPageDto.setSize(orders.getSize());
        ordersPageDto.setLast(orders.isLast());
        ordersPageDto.setNumber(orders.getNumber());
        ordersPageDto.setTotalElements(orders.getTotalElements());

        List<Order> orderList = orders.getContent();
        OrdersResponseDto ordersResponseDto = ordersToOrdersResponseDto(orderList);

        ordersPageDto.setOrdersResponseDto(ordersResponseDto);

        return ordersPageDto;
    };
}
