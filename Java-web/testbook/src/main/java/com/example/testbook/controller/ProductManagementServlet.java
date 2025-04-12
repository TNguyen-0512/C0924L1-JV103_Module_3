package com.example.testbook.controller;

import com.example.testbook.model.Product;
import com.example.testbook.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManagementServlet", value = "/productmanagement")
public class ProductManagementServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "delete":

                break;
            case "update":

                break;
            case "search":

                break;
            default:
                showList(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":

                break;
            case "update":

                break;
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> bookList = productService.findAllBooks();
        req.setAttribute("bookList", bookList);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
