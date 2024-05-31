package io.elice.shoppingmall.category.repository;

import io.elice.shoppingmall.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // 추가적인 쿼리 메소드 정의 가능
}
