package io.elice.shoppingmall.category.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
//@Getter
//@Setter
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    @Column(name = "category_parent_category_id")
    private Integer parentCategoryId;

    private Boolean isDeleted;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookCategoryMapper> book_category_mapper;
}
