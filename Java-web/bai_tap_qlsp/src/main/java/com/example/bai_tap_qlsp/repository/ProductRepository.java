package com.example.bai_tap_qlsp.repository;


import com.example.bai_tap_qlsp.model.Product;
import com.example.bai_tap_qlsp.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String SELECT_ALL ="select * from products";
    private final String DELETE_BY_ID ="delete from products where id =?";
    private final String INSERT_INTO ="insert into products(name,price,description,manufacturer) values (?,?,?,?)";
    private final String UPDATE_PRODUCT = "UPDATE products SET name = ?, price = ?, description = ?, manufacturer = ? WHERE id = ?";
    private final String FIND_BY_NAME = "SELECT * FROM products WHERE name LIKE ?";
    Connection conn = BaseRepository.getConnection();
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name  = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");
                Product product = new Product(id,name,price,description,manufacturer);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    @Override
    public boolean add(Product product) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1,product.getName());
            preparedStatement.setDouble(2,product.getPrice());
            preparedStatement.setString(3,product.getDescription());
            preparedStatement.setString(4,product.getManufacturer());
            int effectRow = preparedStatement.executeUpdate();
            return effectRow ==1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
            return false;
        }
    }

    @Override
    public void update(Product product) {
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(UPDATE_PRODUCT)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setString(3, product.getDescription());
            preparedStatement.setString(4, product.getManufacturer());
            preparedStatement.setInt(5, product.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Lỗi cập nhật sản phẩm: " + e.getMessage());
        }
    }

    @Override
    public boolean delete(int id) {
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1,id);
            int effectRow = preparedStatement.executeUpdate();
            return effectRow ==1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
            return false;
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(FIND_BY_NAME)) {

            preparedStatement.setString(1, "%" + name + "%"); // Tìm kiếm gần đúng (LIKE)
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String productName = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                String description = resultSet.getString("description");
                String manufacturer = resultSet.getString("manufacturer");

                Product product = new Product(id, productName, price, description, manufacturer);
                searchList.add(product);
            }
        } catch (SQLException e) {
            System.out.println("Lỗi tìm kiếm sản phẩm: " + e.getMessage());
        }
        return searchList;
    }

}
