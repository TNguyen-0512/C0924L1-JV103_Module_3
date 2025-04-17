package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.dto.KhachHangDTO;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository implements IKhachHangRepository {
    private final String SELECT_ALL = "SELECT kh.*, lk.ten_loai_khach FROM khach_hang kh LEFT JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach";
    private final String DELETE_BY_ID = "DELETE FROM khach_hang WHERE ma_khach_hang = ?";
    private final String INSERT_INTO = "INSERT INTO khach_hang (ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi, ma_loai_khach) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String UPDATE = "UPDATE khach_hang SET ho_ten = ?, ngay_sinh = ?, gioi_tinh = ?, so_cmnd = ?, so_dien_thoai = ?, email = ?, dia_chi = ?, ma_loai_khach = ? WHERE ma_khach_hang = ?";
    private final String FIND_BY_NAME = "SELECT kh.*, lk.ten_loai_khach FROM khach_hang kh LEFT JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach WHERE ho_ten LIKE ?";
    private final String FIND_BY_ID = "SELECT kh.*, lk.ten_loai_khach FROM khach_hang kh LEFT JOIN loai_khach lk ON kh.ma_loai_khach = lk.ma_loai_khach WHERE kh.ma_khach_hang = ?";
    private final String GET_ID_BY_NAME = "SELECT ma_loai_khach FROM loai_khach WHERE ten_loai_khach = ?";
    Connection conn = BaseRepository.getConnection();

    @Override
    public List<KhachHangDTO> findAll() {
        List<KhachHangDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                KhachHangDTO dto = new KhachHangDTO();
                dto.setMaKhachHang(rs.getInt("ma_khach_hang"));
                dto.setHoTen(rs.getString("ho_ten"));
                dto.setNgaySinh(rs.getDate("ngay_sinh"));
                dto.setGioiTinh(rs.getBoolean("gioi_tinh"));
                dto.setSoCMND(rs.getString("so_cmnd"));
                dto.setSoDienThoai(rs.getString("so_dien_thoai"));
                dto.setEmail(rs.getString("email"));
                dto.setDiaChi(rs.getString("dia_chi"));
                dto.setLoaiKhach(rs.getString("ten_loai_khach"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean add(KhachHangDTO khachHang) {
        try {
            // Lấy ID từ tên loại khách
            int maLoaiKhach = 0;
            try (PreparedStatement getIdStmt = conn.prepareStatement(GET_ID_BY_NAME)) {
                getIdStmt.setString(1, khachHang.getLoaiKhach());
                ResultSet rs = getIdStmt.executeQuery();
                if (rs.next()) {
                    maLoaiKhach = rs.getInt("ma_loai_khach");
                } else {
                    return false; // Không tìm thấy loại khách
                }
            }

            PreparedStatement stmt = conn.prepareStatement(INSERT_INTO);
            stmt.setString(1, khachHang.getHoTen());
            stmt.setDate(2, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            stmt.setBoolean(3, khachHang.isGioiTinh());
            stmt.setString(4, khachHang.getSoCMND());
            stmt.setString(5, khachHang.getSoDienThoai());
            stmt.setString(6, khachHang.getEmail());
            stmt.setString(7, khachHang.getDiaChi());
            stmt.setInt(8, maLoaiKhach);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(KhachHangDTO khachHang) {
        try {
            // Truy vấn ra mã loại khách từ tên
            int maLoaiKhach = 0;
            try (PreparedStatement getIdStmt = conn.prepareStatement(GET_ID_BY_NAME)) {
                getIdStmt.setString(1, khachHang.getLoaiKhach());
                ResultSet rs = getIdStmt.executeQuery();
                if (rs.next()) {
                    maLoaiKhach = rs.getInt("ma_loai_khach");
                } else {
                    return false; // không tìm thấy
                }
            }

            PreparedStatement stmt = conn.prepareStatement(UPDATE);
            stmt.setString(1, khachHang.getHoTen());
            stmt.setDate(2, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            stmt.setBoolean(3, khachHang.isGioiTinh());
            stmt.setString(4, khachHang.getSoCMND());
            stmt.setString(5, khachHang.getSoDienThoai());
            stmt.setString(6, khachHang.getEmail());
            stmt.setString(7, khachHang.getDiaChi());
            stmt.setInt(8, maLoaiKhach); // dùng mã loại khách thực sự
            stmt.setInt(9, khachHang.getMaKhachHang());

            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }



    @Override
    public boolean delete(int id) {
        try (PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<KhachHangDTO> findByName(String name) {
        List<KhachHangDTO> list = new ArrayList<>();
        try (PreparedStatement stmt = conn.prepareStatement(FIND_BY_NAME)) {
            stmt.setString(1, "%" + name + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhachHangDTO dto = new KhachHangDTO();
                dto.setMaKhachHang(rs.getInt("ma_khach_hang"));
                dto.setHoTen(rs.getString("ho_ten"));
                dto.setNgaySinh(rs.getDate("ngay_sinh"));
                dto.setGioiTinh(rs.getBoolean("gioi_tinh"));
                dto.setSoCMND(rs.getString("so_cmnd"));
                dto.setSoDienThoai(rs.getString("so_dien_thoai"));
                dto.setEmail(rs.getString("email"));
                dto.setDiaChi(rs.getString("dia_chi"));
                dto.setLoaiKhach(rs.getString("ten_loai_khach"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public KhachHangDTO findById(int id) {
        KhachHangDTO dto = null;
        try (PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                dto = new KhachHangDTO();
                dto.setMaKhachHang(rs.getInt("ma_khach_hang"));
                dto.setHoTen(rs.getString("ho_ten"));
                dto.setNgaySinh(rs.getDate("ngay_sinh"));
                dto.setGioiTinh(rs.getBoolean("gioi_tinh"));
                dto.setSoCMND(rs.getString("so_cmnd"));
                dto.setSoDienThoai(rs.getString("so_dien_thoai"));
                dto.setEmail(rs.getString("email"));
                dto.setDiaChi(rs.getString("dia_chi"));
                dto.setLoaiKhach(rs.getString("ten_loai_khach"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dto;
    }
}