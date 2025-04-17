package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.dto.NhanVienDTO;
import com.example.do_an_ca_nhan.model.NhanVien;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository implements INhanVienRepository {

    private final String SELECT_ALL = "SELECT nv.*, vt.ten_vi_tri, td.ten_trinh_do, bp.ten_bo_phan\n" +
            "FROM nhan_vien nv\n" +
            "LEFT JOIN vi_tri vt ON nv.ma_vi_tri = vt.ma_vi_tri\n" +
            "LEFT JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do\n" +
            "LEFT JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan";

    private final String SELECT_BY_ID_JOIN = "SELECT nv.*, vt.ten_vi_tri, td.ten_trinh_do, bp.ten_bo_phan " +
            "FROM nhan_vien nv " +
            "JOIN vi_tri vt ON nv.ma_vi_tri = vt.ma_vi_tri " +
            "JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do " +
            "JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan " +
            "WHERE nv.ma_nhan_vien = ?";

    private final String DELETE_BY_ID = "DELETE FROM nhan_vien WHERE ma_nhan_vien = ?";

    private final String INSERT = "INSERT INTO nhan_vien (ho_ten, ngay_sinh, so_cmnd, luong, so_dien_thoai, email, dia_chi, ma_vi_tri, ma_trinh_do, ma_bo_phan) " +
            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String UPDATE = "UPDATE nhan_vien SET ho_ten = ?, ngay_sinh = ?, so_cmnd = ?, so_dien_thoai = ?, email = ?, dia_chi = ?, luong = ?, ma_vi_tri = ?, ma_trinh_do = ?, ma_bo_phan = ? WHERE ma_nhan_vien = ?";

    private final String FIND_BY_NAME = "SELECT nv.*, vt.ten_vi_tri, td.ten_trinh_do, bp.ten_bo_phan " +
            "FROM nhan_vien nv " +
            "LEFT JOIN vi_tri vt ON nv.ma_vi_tri = vt.ma_vi_tri " +
            "LEFT JOIN trinh_do td ON nv.ma_trinh_do = td.ma_trinh_do " +
            "LEFT JOIN bo_phan bp ON nv.ma_bo_phan = bp.ma_bo_phan " +
            "WHERE nv.ho_ten LIKE ?";

    private final String FIND_BY_ID = "SELECT * FROM nhan_vien WHERE ma_nhan_vien = ?";

    Connection conn = BaseRepository.getConnection();

    @Override
    public List<NhanVienDTO> findAll() {
        List<NhanVienDTO> nhanVienList = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                nv.setHoTen(rs.getString("ho_ten"));
                nv.setNgaySinh(rs.getDate("ngay_sinh"));
                nv.setSoCMND(rs.getString("so_cmnd"));
                nv.setLuong(rs.getDouble("luong"));
                nv.setSoDienThoai(rs.getString("so_dien_thoai"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setTenViTri(rs.getString("ten_vi_tri"));
                nv.setTenTrinhDo(rs.getString("ten_trinh_do"));
                nv.setTenBoPhan(rs.getString("ten_bo_phan"));
                nhanVienList.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nhanVienList;
    }

    public NhanVienDTO findDTOById(int id) {
        NhanVienDTO nv = null;
        try (PreparedStatement ps = conn.prepareStatement(SELECT_BY_ID_JOIN)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                nv.setHoTen(rs.getString("ho_ten"));
                nv.setNgaySinh(rs.getDate("ngay_sinh"));
                nv.setSoCMND(rs.getString("so_cmnd"));
                nv.setLuong(rs.getDouble("luong"));
                nv.setSoDienThoai(rs.getString("so_dien_thoai"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setTenViTri(rs.getString("ten_vi_tri"));
                nv.setTenTrinhDo(rs.getString("ten_trinh_do"));
                nv.setTenBoPhan(rs.getString("ten_bo_phan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }

    @Override
    public List<NhanVienDTO> findByName(String name) {
        List<NhanVienDTO> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(FIND_BY_NAME)) {
            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                nv.setHoTen(rs.getString("ho_ten"));
                nv.setNgaySinh(rs.getDate("ngay_sinh"));
                nv.setSoCMND(rs.getString("so_cmnd"));
                nv.setLuong(rs.getDouble("luong"));
                nv.setSoDienThoai(rs.getString("so_dien_thoai"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setTenViTri(rs.getString("ten_vi_tri"));
                nv.setTenTrinhDo(rs.getString("ten_trinh_do"));
                nv.setTenBoPhan(rs.getString("ten_bo_phan"));
                list.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public NhanVien findById(int id) {
        NhanVien nv = null;
        try (PreparedStatement ps = conn.prepareStatement(FIND_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nv = new NhanVien();
                nv.setMaNhanVien(rs.getInt("ma_nhan_vien"));
                nv.setHoTen(rs.getString("ho_ten"));
                nv.setNgaySinh(rs.getDate("ngay_sinh"));
                nv.setSoCMND(rs.getString("so_cmnd"));
                nv.setLuong(rs.getDouble("luong"));
                nv.setSoDienThoai(rs.getString("so_dien_thoai"));
                nv.setEmail(rs.getString("email"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setMaViTri(rs.getInt("ma_vi_tri"));
                nv.setMaTrinhDo(rs.getInt("ma_trinh_do"));
                nv.setMaBoPhan(rs.getInt("ma_bo_phan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nv;
    }

    @Override
    public boolean add(NhanVien nv) {
        try (PreparedStatement ps = conn.prepareStatement(INSERT)) {
            ps.setString(1, nv.getHoTen());
            ps.setDate(2, nv.getNgaySinh());
            ps.setString(3, nv.getSoCMND());
            ps.setDouble(4, nv.getLuong());
            ps.setString(5, nv.getSoDienThoai());
            ps.setString(6, nv.getEmail());
            ps.setString(7, nv.getDiaChi());
            ps.setInt(8, nv.getMaViTri());
            ps.setInt(9, nv.getMaTrinhDo());
            ps.setInt(10, nv.getMaBoPhan());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(NhanVien nv) {
        try (PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, nv.getHoTen());
            ps.setDate(2, nv.getNgaySinh());
            ps.setString(3, nv.getSoCMND());
            ps.setString(4, nv.getSoDienThoai());
            ps.setString(5, nv.getEmail());
            ps.setString(6, nv.getDiaChi());
            ps.setDouble(7, nv.getLuong());
            ps.setInt(8, nv.getMaViTri());
            ps.setInt(9, nv.getMaTrinhDo());
            ps.setInt(10, nv.getMaBoPhan());
            ps.setInt(11, nv.getMaNhanVien());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = conn.prepareStatement(DELETE_BY_ID)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
