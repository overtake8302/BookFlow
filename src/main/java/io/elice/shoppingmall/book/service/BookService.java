package io.elice.shoppingmall.book.service;

import io.elice.shoppingmall.book.model.Dto.BookFormDto;
import io.elice.shoppingmall.book.model.Entity.Book;
import io.elice.shoppingmall.book.model.Entity.BookImg;
import io.elice.shoppingmall.book.repository.BookImgRepository;
import io.elice.shoppingmall.book.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@Transactional
public class BookService {
/*    public BookService() {
    }

    //책 등록
    public Long saveBook(BookFormDto bookFormDto, BookImg bookImgs){
        Book book = bookFormDto.createItem();
        bookRepository.save(book);
        BookImg bookImg = new BookImg();
        bookImg.setBook(book);
        return book.getId();
    }

    // 상품 조회
    @Transactional(readOnly = true)
    public BookFormDto getbookDetail(Long bookId) {


        //상품 이미지 엔티티 > 상품 이미지 dto로 변환
        //상품 엔티티를 상품 폼 디티오로 변환


    }

    // 상품 수정
    public Long updateBook(BookFormDto bookFormDto, BookImg bookImg) throws IOException {

        // 상품 수정
        Book book = bookRepository.findById(bookFormDto.getId()).orElseThrow(EntityNotFoundException::new);
        book.updateBook(bookFormDto);

        // 상품 이미지 수정


        return book.getId();
    }*/
}
