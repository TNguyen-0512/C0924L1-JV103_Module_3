package com.example.bai_tap_qlsp.controller;

import com.example.bai_tap_qlsp.model.Product;
import com.example.bai_tap_qlsp.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "create":
                showFormCreate(req,resp);
                break;
            case "delete":
                break;
            case "update":
                break;
            default:
                showList(req,resp);

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action ==null){
            action = "";
        }
        switch (action){
            case "create":
                save(req,resp);
                break;
            case "delete":
                break;
            case "update":
                break;
            default:

        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
        double price;
        int id;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            price = Double.parseDouble(req.getParameter("price"));
        } catch (NumberFormatException e) {
            req.setAttribute("error", "ID hoặc Giá không hợp lệ!");
            showFormCreate(req, resp);
            return;
        }
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");
        Product product = new Product(id, name, price, description, manufacturer);
        boolean flag = productService.add(product);
        if (flag) {
            resp.sendRedirect("/products?mess=Thêm thành công");
        } else {
            showFormCreate(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getRequestDispatcher("/views/product/create.jsp").forward(req, resp);
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req,resp);
    }
}
