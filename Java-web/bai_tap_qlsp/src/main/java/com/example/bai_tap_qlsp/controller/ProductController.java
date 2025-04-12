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

import static jdk.jfr.internal.consumer.EventLog.update;

@WebServlet(name = "ProductController", value = "/products")
public class ProductController extends HttpServlet {
    private ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "delete":
                deleteById(req, resp);
                break;
            case "update":
                break;
            case "search":
                searchByName(req, resp);
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
                save(req, resp);
                break;
            case "delete":
                break;
            case "update":
                update(req, resp);
                break;
            default:

        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            String description = req.getParameter("description");
            String manufacturer = req.getParameter("manufacturer");

            Product updatedProduct = new Product(id, name, price, description, manufacturer);
            boolean isUpdated = productService.update(updatedProduct);

            String mess = isUpdated ? "Update success" : "Update failed";
            resp.sendRedirect("/products?mess=" + mess);
        } catch (NumberFormatException e) {
            resp.sendRedirect("/products?mess=Invalid input");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double price;
        try {
//            id = productService.findAll().size() + 1;
            price = Double.parseDouble(req.getParameter("price"));
        } catch (NumberFormatException e) {
            req.setAttribute("error", "ID hoặc Giá không hợp lệ!");
            showFormCreate(req, resp);
            return;
        }
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        String manufacturer = req.getParameter("manufacturer");
        Product product = new Product(name, price, description, manufacturer);
        boolean flag = productService.add(product);
        if (flag) {
            resp.sendRedirect("/products?mess=Add succsess");
        } else {
            showFormCreate(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/product/create.jsp").forward(req, resp);
    }
    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.findAll();
        req.setAttribute("products", products);
        req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean isDeleteSuccess = productService.delete(deleteId);
        String mess = "Delete not success";
        if (isDeleteSuccess) {
            mess = "Delete success";
        }
        resp.sendRedirect("/products?mess=" + mess);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) {
        String searchName = req.getParameter("searchName");
        List<Product> result = productService.findByName(searchName);
        req.setAttribute("products", result);
        req.setAttribute("searchName", searchName);
        try {
            req.getRequestDispatcher("/views/product/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
