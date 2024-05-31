package io.elice.shoppingmall.category.service;




import io.elice.shoppingmall.category.model.Category;
import io.elice.shoppingmall.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Integer id, Category category) {
        Category existingCategory = getCategoryById(id);
        existingCategory.setCategoryName(category.getCategoryName());
        existingCategory.setParentCategoryId(category.getParentCategoryId());
        existingCategory.setIsDeleted(category.getIsDeleted());
        return categoryRepository.save(existingCategory);
    }

    public void deleteCategory(Integer id) {
        Category category = getCategoryById(id);
        category.setIsDeleted(true);
        categoryRepository.save(category);
    }
}
