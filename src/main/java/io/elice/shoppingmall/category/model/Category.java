package io.elice.shoppingmall.category.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    @Column(name = "category_parent_category_id")
    private Integer parentCategoryId;

    private Boolean isDeleted;
}
