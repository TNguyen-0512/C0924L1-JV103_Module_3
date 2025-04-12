package com.example.bai_tap_qlsp.service;

import com.example.bai_tap_qlsp.model.Product;
import com.example.bai_tap_qlsp.repository.IProductRepository;
import com.example.bai_tap_qlsp.repository.ProductRepository;

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

    @Override
    public boolean update(Product product) {
        return productRepository.update(product);
    }

    @Override
    public boolean delete(int id) {
        return  productRepository.delete(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
}
