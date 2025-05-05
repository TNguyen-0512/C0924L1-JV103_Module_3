package com.example.do_an_ca_nhan.controller;

import com.example.do_an_ca_nhan.dto.DichVuDTO;
import com.example.do_an_ca_nhan.service.IDichVuService;
import com.example.do_an_ca_nhan.service.DichVuService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DichVuController", value = "/dichvu")
public class DichVuController extends HttpServlet {
    private IDichVuService dichVuService = new DichVuService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create":
                showFormCreate(req, resp);
                break;
            case "edit":
                showFormEdit(req, resp);
                break;
            case "delete":
                deleteById(req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DichVuDTO> list = dichVuService.findAll();
        req.setAttribute("dichVuList", list);
        req.getRequestDispatcher("views/dichvu/list.jsp").forward(req, resp);
    }

    private void showFormCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("kieuThueList", dichVuService.getAllKieuThue());
        req.setAttribute("loaiDichVuList", dichVuService.getAllLoaiDichVu());
        req.getRequestDispatcher("views/dichvu/create.jsp").forward(req, resp);
    }

    private void showFormEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        DichVuDTO dichVu = dichVuService.findById(id);
        req.setAttribute("dichVu", dichVu);
        req.setAttribute("kieuThueList", dichVuService.getAllKieuThue());
        req.setAttribute("loaiDichVuList", dichVuService.getAllLoaiDichVu());
        req.getRequestDispatcher("views/dichvu/edit.jsp").forward(req, resp);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        dichVuService.delete(id);
        resp.sendRedirect("/dichvu");
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String keyword = req.getParameter("keyword");
        List<DichVuDTO> list = dichVuService.searchByName(keyword);
        req.setAttribute("dichVuList", list);
        req.getRequestDispatcher("views/dichvu/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "create":
                save(req, resp);
                break;
            case "update":
                update(req, resp);
                break;
            default:
                resp.sendRedirect("/dichvu");
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DichVuDTO dv = buildDichVuFromRequest(req);
        dichVuService.add(dv);
        resp.sendRedirect("/dichvu");
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DichVuDTO dv = buildDichVuFromRequest(req);
        dv.setMaDichVu(Integer.parseInt(req.getParameter("maDichVu")));
        dichVuService.update(dv);
        resp.sendRedirect("/dichvu");
    }

    private DichVuDTO buildDichVuFromRequest(HttpServletRequest req) {
        DichVuDTO dv = new DichVuDTO();
        dv.setTenDichVu(req.getParameter("tenDichVu"));
        dv.setDienTich(Integer.parseInt(req.getParameter("dienTich")));
        dv.setChiPhiThue(Double.parseDouble(req.getParameter("chiPhiThue")));
        dv.setSoNguoiToiDa(Integer.parseInt(req.getParameter("soNguoiToiDa")));
        dv.setMaKieuThue(Integer.parseInt(req.getParameter("maKieuThue")));
        dv.setMaLoaiDichVu(Integer.parseInt(req.getParameter("maLoaiDichVu")));
        return dv;
    }
}
