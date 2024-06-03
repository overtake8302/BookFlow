package io.elice.shoppingmall.book.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "book")
@Getter
@Setter
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    @Column(name = "book_name")
    private String name;

    @Column(name = "book_price")
    private int price;

    @Column(name = "book_stock")
    private int stock;

    @Column(name = "book_date")
    private String date;

    @Column(name = "book_text")
    private String text;

    @Column(name = "book_img")
    private String img;

    @Column(name = "is_deleted")
    private boolean idDeleted;

}
