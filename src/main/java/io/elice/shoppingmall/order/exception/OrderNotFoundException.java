package io.elice.shoppingmall.order.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
<<<<<<< HEAD
=======
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
>>>>>>> 3bd465834f53b723681605371ce84809a3467005

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
=======
@ResponseStatus(HttpStatus.NOT_FOUND)
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
public class OrderNotFoundException extends RuntimeException {

    private OrderErrorMessages orderErrorMessages;
}
