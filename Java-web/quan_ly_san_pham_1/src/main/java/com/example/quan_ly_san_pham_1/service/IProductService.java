package com.example.quan_ly_san_pham_1.service;

import com.example.quan_ly_san_pham_1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product product);
}
