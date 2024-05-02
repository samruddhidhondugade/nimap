package com.example.nimap_assignment.services;

import com.example.nimap_assignment.model.Product;
import com.example.nimap_assignment.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Page<Product> showAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productData) {
        Product product = getProduct(id);
        product.setName(productData.getName());
        product.setBrand(productData.getBrand());
        product.setDescription(productData.getDescription());
        product.setCategory(productData.getCategory());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        Product product = getProduct(id);
        productRepository.delete(product);
    }
}