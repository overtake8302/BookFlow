package io.elice.shoppingmall.user.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminRolePutDto {
    private Long userId;
    private String role;
}
