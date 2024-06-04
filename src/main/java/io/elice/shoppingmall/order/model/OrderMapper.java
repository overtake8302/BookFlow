package io.elice.shoppingmall.order.model;

import io.elice.shoppingmall.book.model.Book;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    /*@Autowired
    BookService bookservice;*/
    OrderResponseDto orderToOrderResponseDto(Order order);
    Order orderCreateDtoToOrder(OrderCreateDto orderCreateDto);
    OrderDelivery orderCreateDtoToOrderDelivery(OrderCreateDto orderCreateDto);

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
}
