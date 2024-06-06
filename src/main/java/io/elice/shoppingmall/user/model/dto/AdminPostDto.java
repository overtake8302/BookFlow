package io.elice.shoppingmall.user.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminPostDto {
    private Long userId;
    private String username;
    private String role;
    private String name;
    private String phoneNumber;
}
