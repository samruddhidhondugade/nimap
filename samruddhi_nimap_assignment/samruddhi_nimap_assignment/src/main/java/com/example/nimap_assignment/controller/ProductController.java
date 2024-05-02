package com.example.nimap_assignment.controller;

import com.example.nimap_assignment.model.Product;
import com.example.nimap_assignment.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllProducts(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "4") int size) {
        Page<Product> products = productService.showAllProducts(PageRequest.of(page - 1, size));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{di}")
    public ResponseEntity<Product> getProductById(@PathVariable("di") Long id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product addedProduct = productService.addProduct(product);
        return ResponseEntity.status(HttpStatus.OK).body(addedProduct);
    }

    @PutMapping("/{di}")
    public ResponseEntity<Product> updateProduct(@PathVariable("di") Long id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{di}")
    public ResponseEntity<?> deleteProduct(@PathVariable("di") Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted...id = " + id);
    }
}