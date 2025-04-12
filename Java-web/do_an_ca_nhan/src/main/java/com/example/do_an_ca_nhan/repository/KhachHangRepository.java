package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.KhachHang;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository implements IKhachHangRepository {
    private final String SELECT_ALL ="select * from khach_hang";
    private final String DELETE_BY_ID ="delete from khach_hang where ma_khach_hang =?";
    private final String INSERT_INTO ="insert into khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach) values (?,?,?,?,?,?,?,?)";
    private final String UPDATE_PRODUCT = "update khach_hang set ho_ten=?, ngay_sinh=?, gioi_tinh=?, so_cmnd=?, so_dien_thoai=?, email=?, dia_chi=?, ma_loai_khach=? where ma_khach_hang=?";
    private final String FIND_BY_NAME = "SELECT * FROM khach_hang WHERE ho_ten LIKE ?";
    private final String FIND_BY_ID="SELECT * FROM khach_hang WHERE ma_khach_hang =?";
    Connection conn = BaseRepository.getConnection();
    @Override
    public List<KhachHang> findAll() {
        List <KhachHang> list = new ArrayList();
        try {
            PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKhachHang(rs.getInt("ma_khach_hang"));
                khachHang.setHoTen(rs.getString("ho_ten"));
                khachHang.setNgaySinh(rs.getDate("ngay_sinh"));
                khachHang.setGioiTinh(rs.getBoolean("gioi_tinh"));
                khachHang.setSoCMND(rs.getString("so_cmnd"));
                khachHang.setSoDienThoai(rs.getString("so_dien_thoai"));
                khachHang.setEmail(rs.getString("email"));
                khachHang.setDiaChi(rs.getString("dia_chi"));
                khachHang.setMaLoaiKhach(rs.getInt("ma_loai_khach"));
                list.add(khachHang);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean add(KhachHang khachHang) {
        try {
            PreparedStatement stmt = conn.prepareStatement(INSERT_INTO);
            stmt.setString(1, khachHang.getHoTen());
            stmt.setDate(2, (Date) khachHang.getNgaySinh());
            stmt.setBoolean(3, khachHang.isGioiTinh());
            stmt.setString(4, khachHang.getSoCMND());
            stmt.setString(5, khachHang.getSoDienThoai());
            stmt.setString(6,  khachHang.getEmail());
            stmt.setString(7, khachHang.getDiaChi());
            stmt.setInt(8, khachHang.getMaLoaiKhach());
            int effectRow = stmt.executeUpdate();
            return effectRow ==1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
            return false;
        }
    }

    @Override
    public boolean update(KhachHang khachHang) {
        try {
            PreparedStatement stmt = conn.prepareStatement(UPDATE_PRODUCT);
            stmt.setString(1, khachHang.getHoTen());
            stmt.setDate(2, (Date) khachHang.getNgaySinh());
            stmt.setBoolean(3, khachHang.isGioiTinh());
            stmt.setString(4, khachHang.getSoCMND());
            stmt.setString(5, khachHang.getSoDienThoai());
            stmt.setString(6, khachHang.getEmail());
            stmt.setString(7, khachHang.getDiaChi());
            stmt.setInt(8, khachHang.getMaLoaiKhach());
            stmt.setInt(9, khachHang.getMaKhachHang());
            int effectRow = stmt.executeUpdate();
            return effectRow == 1;
        } catch (SQLException e) {
            System.out.println("lỗi kết nối database");
            return false;
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
    public List<KhachHang> findByName(String name) {
        List<KhachHang> searchList = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(FIND_BY_NAME);
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang()   ;
                khachHang.setMaKhachHang(rs.getInt("ma_khach_hang"));
                khachHang.setHoTen(rs.getString("ho_ten"));
                khachHang.setNgaySinh(rs.getDate("ngay_sinh"));
                khachHang.setGioiTinh(rs.getBoolean("gioi_tinh"));
                khachHang.setSoCMND(rs.getString("so_cmnd"));
                khachHang.setSoDienThoai(rs.getString("so_dien_thoai"));
                khachHang.setEmail(rs.getString("email"));
                khachHang.setDiaChi(rs.getString("dia_chi"));
                khachHang.setMaLoaiKhach(rs.getInt("ma_loai_khach"));
                searchList.add(khachHang);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return searchList;
    }

    @Override
    public KhachHang findById(int id) {
        KhachHang khachHang = null;
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                khachHang = new KhachHang();
                khachHang.setMaKhachHang(rs.getInt("ma_khach_hang"));
                khachHang.setHoTen(rs.getString("ho_ten"));
                khachHang.setNgaySinh(rs.getDate("ngay_sinh"));
                khachHang.setGioiTinh(rs.getBoolean("gioi_tinh"));
                khachHang.setSoCMND(rs.getString("so_cmnd"));
                khachHang.setSoDienThoai(rs.getString("so_dien_thoai"));
                khachHang.setEmail(rs.getString("email"));
                khachHang.setDiaChi(rs.getString("dia_chi"));
                khachHang.setMaLoaiKhach(rs.getInt("ma_loai_khach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return khachHang;
    }
}
