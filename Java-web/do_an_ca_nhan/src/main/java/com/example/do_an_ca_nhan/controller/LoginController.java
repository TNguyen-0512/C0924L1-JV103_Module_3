package com.example.do_an_ca_nhan.controller;

import com.example.do_an_ca_nhan.dto.NhanVienDTO;
import com.example.do_an_ca_nhan.util.BaseRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String input = request.getParameter("email");
        String matKhau = request.getParameter("password");

        System.out.println("Input: " + input);
        System.out.println("Password: " + matKhau);

        try (Connection conn = BaseRepository.getConnection()) {
            String sql = "SELECT * FROM nhan_vien WHERE (email = ? OR so_dien_thoai = ?) AND mat_khau = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, input);
                stmt.setString(2, input);
                stmt.setString(3, matKhau);

                try (ResultSet rs = stmt.executeQuery())
                {System.out.println("Đã chạy truy vấn SQL");
                    if (rs.next()) {
                        NhanVienDTO user = new NhanVienDTO();
                        user.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                        user.setHoTen(rs.getString("ho_ten"));
                        user.setEmail(rs.getString("email"));
                        user.setSoDienThoai(rs.getString("so_dien_thoai"));

                        HttpSession session = request.getSession();
                        session.setAttribute("user", user);
                        session.setAttribute("username", user.getHoTen());
                        response.sendRedirect("/home");
                        System.out.println("Đăng nhập thành công!");
                    } else {
                        request.setAttribute("error", "Email/SĐT hoặc mật khẩu không đúng!");
                        request.getRequestDispatcher("login.jsp").forward(request, response);
                        System.out.println("Không tìm thấy tài khoản!");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi kết nối CSDL: " + e.getMessage());
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
