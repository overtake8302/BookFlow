package io.elice.shoppingmall.order.exception;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderExceptionMapper {

    OrderExceptionResponseDto noOrdersExceptionToOrderExceptionResponseDto(NoOrdersException e);
    OrderExceptionResponseDto orderAccessDeniedExceptionToOrderExceptionResponseDto(OrderAccessdeniedException e);
    OrderExceptionResponseDto orderNotFoundExceptionToORderExceptionResponseDto(OrderNotFoundException e);
}
