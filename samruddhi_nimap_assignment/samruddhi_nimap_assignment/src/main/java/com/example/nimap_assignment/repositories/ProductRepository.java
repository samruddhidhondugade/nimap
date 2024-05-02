package com.example.nimap_assignment.repositories;

import com.example.nimap_assignment.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
