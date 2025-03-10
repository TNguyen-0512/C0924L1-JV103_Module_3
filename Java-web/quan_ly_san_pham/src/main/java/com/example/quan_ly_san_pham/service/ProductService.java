package com.example.quan_ly_san_pham.service;

import com.example.quan_ly_san_pham.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static List<Product> products = new ArrayList<Product>();

    static {
        products.add(new Product(1, "Laptop Dell", 25000000, "Laptop hiệu Dell", "Dell"));
        products.add(new Product(2, "Chuột Logitech", 500000, "Chuột không dây Logitech", "Logitech"));
        products.add(new Product(3, "Bàn phím cơ Keychron", 1000000, "Bàn phím cơ không dây Keychron", "Keychron"));
        products.add(new Product(4, "Màn hình LG 27 inch", 30000000, "Màn hình gaming LG 144Hz", "LG"));
        products.add(new Product(5, "Tai nghe Sony WH-1000XM4", 1200000, "Tai nghe chống ồn Sony", "Sony"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        return products.stream().filter(product -> product.getId() == id).findFirst().orElse(null);
    }

    @Override
    public boolean addProduct(Product product) {
        return products.add(product);
    }

    @Override
    public void updateProduct(Product product) {
        deleteProduct(product.getId());
        products.add(product);
    }

    @Override
    public void deleteProduct(int id) {
       boolean check = products.removeIf(product -> product.getId() == id);
       if (!check) {
           System.out.println("Không tìm thấy sản phẩm với ID: "+ id);
       }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }
}