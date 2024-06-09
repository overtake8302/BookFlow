package io.elice.shoppingmall.order.model;

import io.elice.shoppingmall.audit.BaseEntity;
import io.elice.shoppingmall.book.model.Entity.Book;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @Column(nullable = false)
    private int orderItemPrice;

    @Column(nullable = false)
    private int orderItemTotalPrice;

    @Column(nullable = false)
    private int orderItemQuantity;

    private boolean isDeleted;

    //양방향 참조시 순환참조로 에러 발생
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
