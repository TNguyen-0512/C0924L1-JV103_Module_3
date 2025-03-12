package com.example.bai_tap_qlsp.repository;


import com.example.bai_tap_qlsp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<Product>();

    static {
        products.add(new Product(1, "Laptop Dell", 25000000, "Laptop hiệu Dell", "Dell"));
        products.add(new Product(2, "Chuột Logitech", 500000, "Chuột không dây Logitech", "Logitech"));
        products.add(new Product(3, "Bàn phím cơ Keychron", 1000000, "Bàn phím cơ không dây Keychron", "Keychron"));
        products.add(new Product(4, "Màn hình LG 27 inch", 30000000, "Màn hình gaming LG 144Hz", "LG"));
        products.add(new Product(5, "Tai nghe Sony WH-1000XM4", 1200000, "Tai nghe chống ồn Sony", "Sony"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public boolean add(Product product) {
        return products.add(product);
    }
}
