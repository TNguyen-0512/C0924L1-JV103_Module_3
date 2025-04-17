package com.example.do_an_ca_nhan.controller;

import com.example.do_an_ca_nhan.dto.KhachHangDTO;
import com.example.do_an_ca_nhan.model.LoaiKhach;
import com.example.do_an_ca_nhan.service.IKhachHangService;
import com.example.do_an_ca_nhan.service.ILoaiKhachService;
import com.example.do_an_ca_nhan.service.KhachHangService;
import com.example.do_an_ca_nhan.service.LoaiKhachService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "KhachHangController", value = "/khachhang")
public class KhachHangController extends HttpServlet {
    private IKhachHangService khachHangService = new KhachHangService();
    private ILoaiKhachService loaiKhachService = new LoaiKhachService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
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
            case "edit":
                showFormEdit(req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<LoaiKhach> loaiKhachList = loaiKhachService.findAll();
        req.setAttribute("loaiKhachList", loaiKhachList);
        req.getRequestDispatcher("/views/khach_hang/them_khach_hang.jsp").forward(req, resp);
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhachHangDTO> khachHangList = khachHangService.findAll();
        req.setAttribute("khachHangList", khachHangList);
        req.getRequestDispatcher("/views/khach_hang/danh_sach_khach_hang.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = khachHangService.delete(id);
        String mess = isDeleted ? "Delete success" : "Delete not success";
        resp.sendRedirect("/khachhang?mess=" + mess);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchName");
        List<KhachHangDTO> khachHangList = khachHangService.findByName(name);
        req.setAttribute("khachHangList", khachHangList);
        req.setAttribute("searchName", name);
        req.getRequestDispatcher("/views/khach_hang/danh_sach_khach_hang.jsp").forward(req, resp);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        KhachHangDTO khachHangEdit = khachHangService.findById(id);
        List<LoaiKhach> loaiKhachList = loaiKhachService.findAll();
        req.setAttribute("khachHangEdit", khachHangEdit);
        req.setAttribute("loaiKhachList", loaiKhachList);
        req.getRequestDispatcher("/views/khach_hang/sua_khach_hang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                save(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            default:
                resp.sendRedirect("/khachhang");
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String hoTen = req.getParameter("hoTen");
        Date ngaySinh = Date.valueOf(req.getParameter("ngaySinh"));
        boolean gioiTinh = Boolean.parseBoolean(req.getParameter("gioiTinh"));
        String soCMND = req.getParameter("soCMND");
        String soDienThoai = req.getParameter("soDienThoai");
        String email = req.getParameter("email");
        String diaChi = req.getParameter("diaChi");
        String loaiKhach = req.getParameter("loaiKhach"); // CHỈ LẤY TÊN loại khách
        KhachHangDTO kh = new KhachHangDTO();
        kh.setHoTen(hoTen);
        kh.setNgaySinh(ngaySinh);
        kh.setGioiTinh(gioiTinh);
        kh.setSoCMND(soCMND);
        kh.setSoDienThoai(soDienThoai);
        kh.setEmail(email);
        kh.setDiaChi(diaChi);
        kh.setLoaiKhach(loaiKhach); // Truyền tên loại khách
        boolean isSaved = khachHangService.add(kh);
        String mess = isSaved ? "Thêm khách hàng thành công" : "Thêm khách hàng thất bại";
        resp.sendRedirect("/khachhang?mess=" + mess);
    }


    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            int maKhachHang = Integer.parseInt(req.getParameter("maKhachHang"));
            String hoTen = req.getParameter("hoTen");
            Date ngaySinh = Date.valueOf(req.getParameter("ngaySinh"));
            boolean gioiTinh = Boolean.parseBoolean(req.getParameter("gioiTinh"));
            String soCMND = req.getParameter("soCMND");
            String soDienThoai = req.getParameter("soDienThoai");
            String email = req.getParameter("email");
            String diaChi = req.getParameter("diaChi");
            String maLoaiKhach = req.getParameter("loaiKhach");

            KhachHangDTO khachHang = new KhachHangDTO();
            khachHang.setMaKhachHang(maKhachHang);
            khachHang.setHoTen(hoTen);
            khachHang.setNgaySinh(ngaySinh);
            khachHang.setGioiTinh(gioiTinh);
            khachHang.setSoCMND(soCMND);
            khachHang.setSoDienThoai(soDienThoai);
            khachHang.setEmail(email);
            khachHang.setDiaChi(diaChi);
            khachHang.setLoaiKhach(maLoaiKhach);

            boolean isUpdated = khachHangService.update(khachHang);
            String mess = isUpdated ? "Cập nhật khách hàng thành công" : "Cập nhật khách hàng thất bại";
            resp.sendRedirect("/khachhang?mess=" + mess);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/khachhang?mess=update_error");
        }
    }

}