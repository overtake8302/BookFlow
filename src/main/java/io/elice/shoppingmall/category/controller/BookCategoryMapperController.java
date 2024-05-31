package io.elice.shoppingmall.category.controller;

import io.elice.shoppingmall.category.model.BookCategoryMapper;
import io.elice.shoppingmall.category.service.BookCategoryMapperService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookCategoryMapperController {

    private final BookCategoryMapperService bookCategoryMapperService;

    public BookCategoryMapperController(BookCategoryMapperService bookCategoryMapperService) {
        this.bookCategoryMapperService = bookCategoryMapperService;
    }

    // 관리자용 API
    @GetMapping("/admin/book-category-mapper")
    public List<BookCategoryMapper> getAllBookCategoryMappers() {
        return bookCategoryMapperService.getAllBookCategoryMappers();
    }

    @GetMapping("/admin/book-category-mapper/{id}")
    public ResponseEntity<BookCategoryMapper> getBookCategoryMapperById(@PathVariable Integer id) {
        return ResponseEntity.ok(bookCategoryMapperService.getBookCategoryMapperById(id));
    }

    @PostMapping("/admin/book-category-mapper")
    public ResponseEntity<BookCategoryMapper> createBookCategoryMapper(@RequestBody BookCategoryMapper bookCategoryMapper) {
        return ResponseEntity.ok(bookCategoryMapperService.createBookCategoryMapper(bookCategoryMapper));
    }

    @PutMapping("/admin/book-category-mapper/{id}")
    public ResponseEntity<BookCategoryMapper> updateBookCategoryMapper(@PathVariable Integer id, @RequestBody BookCategoryMapper bookCategoryMapper) {
        return ResponseEntity.ok(bookCategoryMapperService.updateBookCategoryMapper(id, bookCategoryMapper));
    }

    @DeleteMapping("/admin/book-category-mapper/{id}")
    public ResponseEntity<Void> deleteBookCategoryMapper(@PathVariable Integer id) {
        bookCategoryMapperService.deleteBookCategoryMapper(id);
        return ResponseEntity.noContent().build();
    }
}
