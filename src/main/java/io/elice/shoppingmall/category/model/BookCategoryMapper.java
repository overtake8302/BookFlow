package io.elice.shoppingmall.category.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book_category_mapper")
public class BookCategoryMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookCategoryMapperId;

    @Setter
    @Getter
    private Integer bookId;
    @Setter
    @Getter
    private Integer categoryId;
    @Getter
    @Setter
    private Boolean isDeleted;

}
