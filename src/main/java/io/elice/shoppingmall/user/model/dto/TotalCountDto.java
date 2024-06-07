package io.elice.shoppingmall.user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TotalCountDto {
    private Long userTotalCount;
    private Long adminTotalCount;
}
