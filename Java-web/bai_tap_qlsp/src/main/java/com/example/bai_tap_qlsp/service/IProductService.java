package com.example.bai_tap_qlsp.service;

import com.example.bai_tap_qlsp.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean add(Product product);
}
