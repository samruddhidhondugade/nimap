package com.example.nimap_assignment.services;

import com.example.nimap_assignment.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.nimap_assignment.model.Category;
import org.springframework.data.domain.Pageable;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Page<Category> showAllCategories(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long id, Category categoryData) {
        Category category = getCategory(id);
        category.setName(categoryData.getName());
        category.setDescription(categoryData.getDescription());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        Category category = getCategory(id);
        categoryRepository.delete(category);
    }
}
