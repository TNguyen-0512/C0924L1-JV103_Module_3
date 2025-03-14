package com.example.bai_tap_qlsp.repository;

import com.example.bai_tap_qlsp.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean add(Product product);
    void update(Product product);
    boolean delete(int id);
    List<Product> findByName(String name);
}
