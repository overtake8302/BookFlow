package io.elice.shoppingmall.category.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "book_category_mapper")
@Data
public class BookCategoryMapper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookCategoryMapperId;

    private Integer bookId;

    private Boolean isDeleted;

    @ManyToMany(mappedBy = "bookCategoryMappers")
    private List<Category> categories;
}