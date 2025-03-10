package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();
    Product getProductById(int id);
    boolean addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(int id);
    List<Product> findByName(String name);
}
