package com.example.quan_ly_san_pham.controller;

import com.example.quan_ly_san_pham.model.Product;
import com.example.quan_ly_san_pham.service.IProductService;
import com.example.quan_ly_san_pham.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/products")
public class ProductServlet extends HttpServlet {
    private IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "add":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
               showList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }
        switch (action) {
            case "add":
                addList(req, resp);
            case "update":
                break;
            case "delete":
                break;
            default:

        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.getAllProducts();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/list.jsp").forward(req, resp);
    }
    private void addList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");
        Product product = new Product(id, name, price, description, manufacturer);
        productService.addProduct(product);
        resp.sendRedirect("/products");
    }
}
