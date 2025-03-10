package com.example.quan_ly_san_pham_1.service;

import com.example.quan_ly_san_pham_1.model.Product;
import com.example.quan_ly_san_pham_1.repository.IProductRepository;
import com.example.quan_ly_san_pham_1.repository.ProductRepository;

import java.util.List;

public class ProductService implements IProductService {
    private IProductRepository productRepository=new ProductRepository();
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean add(Product product) {
        productRepository.add(product);
        return true;
    }
}
