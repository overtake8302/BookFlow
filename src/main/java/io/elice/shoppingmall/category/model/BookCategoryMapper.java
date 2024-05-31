package io.elice.shoppingmall.category.model;

import jakarta.persistence.*;

import java.awt.print.Book;

@Entity
@Table(name = "book_category_mapper")
public class BookCategoryMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_category_mapper_id")
    private Integer bookCategoryMapperId;

    @Column(name = "book_id", nullable = false)
    private Integer bookId;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    // 관계 설정
    @ManyToOne
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "category_id", insertable = false, updatable = false)
    private Category category;

    // Getter와 Setter 메소드
    public Integer getBookCategoryMapperId() {
        return bookCategoryMapperId;
    }

    public void setBookCategoryMapperId(Integer bookCategoryMapperId) {
        this.bookCategoryMapperId = bookCategoryMapperId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
