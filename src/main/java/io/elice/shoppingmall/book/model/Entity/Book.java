package io.elice.shoppingmall.book.model.Entity;

import io.elice.shoppingmall.audit.BaseEntity;
import io.elice.shoppingmall.category.model.Category;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)
    private Long id;

    @Column(name = "book_name", nullable = false, length = 50)
    private String name;

    @Column(name = "book_price", nullable = false)
    private int price;

    @Column(name = "book_stock", nullable = false)
    private int stock;

    @Column(name = "book_date", nullable = false)
    private String date;

    @Column(name = "book_text", nullable = false)
    private String text;

    @Column(name = "book_img", nullable = false)
    private String img;

    @Column(name = "is_deleted", nullable = false)
    private boolean idDeleted;

    @ManyToMany
    @JoinTable(
            name = "book_category_mapper",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> category;
    //책 판매 상태, 재고관리
}
