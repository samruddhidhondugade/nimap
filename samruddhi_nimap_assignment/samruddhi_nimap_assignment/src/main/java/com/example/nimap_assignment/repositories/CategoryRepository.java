package com.example.nimap_assignment.repositories;

import com.example.nimap_assignment.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
}
