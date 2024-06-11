package io.elice.shoppingmall.category.service;

import io.elice.shoppingmall.category.model.Category;
import io.elice.shoppingmall.category.repository.CategoryRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // 일반 사용자용 메소드
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    // 관리자용 메소드
    @PreAuthorize("hasRole('ADMIN')")
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Category updateCategory(Integer id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setIsDeleted(category.getIsDeleted());
        return categoryRepository.save(existingCategory);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteCategory(Integer id) {
        Category category = getCategoryById(id);
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }
}
