package com.example.bai_tap_1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name= "DiscountServlet", value = "/discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //chạy khi gửi request bằng mothod post
        String productName = req.getParameter("product_description");
        double price = Double.parseDouble(req.getParameter("list_price"));
        double discountPercent = Double.parseDouble(req.getParameter("dicount_percent"));
        double discountAmount = price*discountPercent*0.1;
        double discountPrice = price-discountAmount;
        req.setAttribute("productName", productName);
        req.setAttribute("discountPercent", discountPercent);
        req.setAttribute("discountAmount", discountAmount);
        req.setAttribute("discountPrice", discountPrice);
        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}
