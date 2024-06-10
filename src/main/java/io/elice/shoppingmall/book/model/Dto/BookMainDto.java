package io.elice.shoppingmall.book.model.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMainDto {
    private Long id;
    private String bookName;
    private String bookDetail;
    private String bookImgUrl;
    private Integer bookPrice;

    public BookMainDto(){}
}
