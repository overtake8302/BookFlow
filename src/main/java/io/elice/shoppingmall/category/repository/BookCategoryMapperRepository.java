package io.elice.shoppingmall.category.repository;

import io.elice.shoppingmall.category.model.BookCategoryMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryMapperRepository extends JpaRepository<BookCategoryMapper, Integer> {
}
