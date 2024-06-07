package io.elice.shoppingmall.category.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    private String categoryName;

    @Column(name = "category_parent_category_id")
    private Integer parentCategoryId;

    private Boolean isDeleted;

    @ManyToMany
    @JoinTable(
            name = "category_book_category_mapper",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "book_category_mapper_id")
    )
    private List<BookCategoryMapper> bookCategoryMappers;

    @ManyToOne
    @JoinColumn(name = "parentCategoryId", insertable = false, updatable = false)
    private Category parentCategory;

    @OneToMany(mappedBy = "parentCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Category> subCategories;
}
