package io.elice.shoppingmall.book.service;

import io.elice.shoppingmall.book.model.Dto.BookFormDto;
import io.elice.shoppingmall.book.model.Entity.Book;
import io.elice.shoppingmall.book.model.Entity.BookImg;
import io.elice.shoppingmall.book.repository.BookImgRepository;
import io.elice.shoppingmall.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class BookImgService {
    private final BookRepository bookRepository;
    private final BookImgService bookImgService;
    private final BookImgRepository bookImgRepository;

    //책 등록
    public Long saveBook(BookFormDto bookFormDto, BookImg bookImg){
        Book book = bookFormDto.createItem();
        //bookRepository.save(book);
        return book.getId();
    }
}
