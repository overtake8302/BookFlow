package io.elice.shoppingmall.book.model.Dto;

import io.elice.shoppingmall.book.model.Entity.BookImg;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;


@Getter
@Setter
public class BookImgDto {
    private Long imgId;
    private String imgName;
    private String imgOriName;
    private String imgUrl;

    //entity -> dto
    private static ModelMapper modelMapper = new ModelMapper();
    public static BookImgDto of(BookImg bookImg) {return modelMapper.map(bookImg, BookImgDto.class);}
}
