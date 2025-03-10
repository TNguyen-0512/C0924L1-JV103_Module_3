package com.example.quan_ly_san_pham_1.repository;

import com.example.quan_ly_san_pham_1.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
}
