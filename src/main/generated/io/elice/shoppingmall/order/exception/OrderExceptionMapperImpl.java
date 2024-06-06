package io.elice.shoppingmall.order.exception;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-06T14:38:52+0900",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
public class OrderExceptionMapperImpl implements OrderExceptionMapper {

    @Override
    public OrderExceptionResponseDto noOrdersExceptionToOrderExceptionResponseDto(NoOrdersException e) {
        if ( e == null ) {
            return null;
        }

        OrderExceptionResponseDto orderExceptionResponseDto = new OrderExceptionResponseDto();

        orderExceptionResponseDto.setOrderErrorMessages( e.getOrderErrorMessages() );

        return orderExceptionResponseDto;
    }

    @Override
    public OrderExceptionResponseDto orderAccessDeniedExceptionToOrderExceptionResponseDto(OrderAccessdeniedException e) {
        if ( e == null ) {
            return null;
        }

        OrderExceptionResponseDto orderExceptionResponseDto = new OrderExceptionResponseDto();

        orderExceptionResponseDto.setOrderErrorMessages( e.getOrderErrorMessages() );

        return orderExceptionResponseDto;
    }

    @Override
    public OrderExceptionResponseDto orderNotFoundExceptionToORderExceptionResponseDto(OrderNotFoundException e) {
        if ( e == null ) {
            return null;
        }

        OrderExceptionResponseDto orderExceptionResponseDto = new OrderExceptionResponseDto();

        orderExceptionResponseDto.setOrderErrorMessages( e.getOrderErrorMessages() );

        return orderExceptionResponseDto;
    }
}
