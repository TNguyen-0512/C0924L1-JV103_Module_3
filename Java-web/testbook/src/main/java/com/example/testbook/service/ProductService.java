package com.example.testbook.service;

import com.example.testbook.model.Product;
import com.example.testbook.repository.ProductRepository;

import java.util.List;

public class ProductService {
    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> findAllBooks() {
        return productRepository.findAllBooks();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id);
    }

}
