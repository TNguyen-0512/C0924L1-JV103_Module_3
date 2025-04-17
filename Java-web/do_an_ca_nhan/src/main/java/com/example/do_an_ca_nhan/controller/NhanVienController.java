package com.example.do_an_ca_nhan.controller;

import com.example.do_an_ca_nhan.dto.NhanVienDTO;
import com.example.do_an_ca_nhan.model.BoPhan;
import com.example.do_an_ca_nhan.model.NhanVien;
import com.example.do_an_ca_nhan.model.TrinhDo;
import com.example.do_an_ca_nhan.model.ViTri;
import com.example.do_an_ca_nhan.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "NhanVienController", value = "/nhanvien")
public class NhanVienController extends HttpServlet {
    private INhanVienService iNhanVienService = new NhanVienService();
    private IBoPhanService iBoPhanService = new BoPhanService();
    private IViTriService iViTriService = new ViTriService();
    private ITrinhDoService iTrinhDoService = new TrinhDoService();

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

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVienDTO> nhanVienList = iNhanVienService.findAll();
        req.setAttribute("nhanVienList", nhanVienList);
        req.getRequestDispatcher("/views/nhan_vien/list.jsp").forward(req, resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("searchName");
        List<NhanVienDTO> nhanVienList = iNhanVienService.findByName(name);
        req.setAttribute("nhanVienList", nhanVienList);
        req.setAttribute("searchName", name);
        req.getRequestDispatcher("/views/nhan_vien/list.jsp").forward(req, resp);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        List<ViTri> viTriList = iViTriService.findAll();
        List<BoPhan> boPhanList = iBoPhanService.findAll();
        List<TrinhDo> trinhDoList = iTrinhDoService .findAll(); // THÊM DÒNG NÀY
        NhanVien nhanVien = iNhanVienService.findById(id);
        req.setAttribute("nhanVien", nhanVien);
        req.setAttribute("boPhanList", boPhanList);
        req.setAttribute("viTriList", viTriList);
        req.setAttribute("trinhDoList", trinhDoList); // TRUYỀN VÀO JSP
        req.getRequestDispatcher("/views/nhan_vien/sua.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isDeleted = iNhanVienService.delete(id);
        String mess = isDeleted ? "Delete success" : "Delete not success";
        resp.sendRedirect("/nhanvien?mess=" + mess);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ViTri> viTriList = iViTriService.findAll();
        List<BoPhan> boPhanList = iBoPhanService.findAll();
        List<TrinhDo> trinhDoList = iTrinhDoService .findAll(); // THÊM DÒNG NÀY
        req.setAttribute("boPhanList", boPhanList);
        req.setAttribute("viTriList", viTriList);
        req.setAttribute("trinhDoList", trinhDoList); // TRUYỀN VÀO JSP
        req.getRequestDispatcher("/views/nhan_vien/them.jsp").forward(req, resp);
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
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String hoTen = req.getParameter("hoTen");
        Date ngaySinh = Date.valueOf(req.getParameter("ngaySinh"));
        String soCMND = req.getParameter("soCMND");
        double luong = Double.parseDouble(req.getParameter("luong"));
        String soDienThoai = req.getParameter("soDienThoai");
        String email = req.getParameter("email");
        String diaChi = req.getParameter("diaChi");
        // Add these three lines to get the values from the form
        int maViTri = Integer.parseInt(req.getParameter("maViTri"));
        int maTrinhDo = Integer.parseInt(req.getParameter("maTrinhDo"));
        int maBoPhan = Integer.parseInt(req.getParameter("maBoPhan"));

        NhanVien nv = new NhanVien();
        nv.setMaNhanVien(id);
        nv.setHoTen(hoTen);
        nv.setNgaySinh(ngaySinh);
        nv.setSoCMND(soCMND);
        nv.setLuong(luong);
        nv.setSoDienThoai(soDienThoai);
        nv.setEmail(email);
        nv.setDiaChi(diaChi);
        nv.setMaViTri(maViTri);
        nv.setMaTrinhDo(maTrinhDo);
        nv.setMaBoPhan(maBoPhan);

        boolean isUpdated = iNhanVienService.update(nv);
        String mess = isUpdated ? "Update success" : "Update not success";
        resp.sendRedirect("/nhanvien?mess=" + mess);
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String hoTen = req.getParameter("hoTen");
        Date ngaySinh = Date.valueOf(req.getParameter("ngaySinh"));
        String soCMND = req.getParameter("soCMND");
        double luong = Double.parseDouble(req.getParameter("luong"));
        String soDienThoai = req.getParameter("soDienThoai");
        String email = req.getParameter("email");
        String diaChi = req.getParameter("diaChi");
        int maViTri = Integer.parseInt(req.getParameter("maViTri"));
        int maTrinhDo = Integer.parseInt(req.getParameter("maTrinhDo"));
        int maBoPhan = Integer.parseInt(req.getParameter("maBoPhan"));

        NhanVien nv = new NhanVien();
        nv.setHoTen(hoTen);
        nv.setNgaySinh(ngaySinh);
        nv.setSoCMND(soCMND);
        nv.setLuong(luong);
        nv.setSoDienThoai(soDienThoai);
        nv.setEmail(email);
        nv.setDiaChi(diaChi);
        nv.setMaViTri(maViTri);
        nv.setMaTrinhDo(maTrinhDo);
        nv.setMaBoPhan(maBoPhan);

        boolean isSaved = iNhanVienService.add(nv);
        String mess = isSaved ? "Create success" : "Create not success";
        resp.sendRedirect("/nhanvien?mess=" + mess);
    }
}
