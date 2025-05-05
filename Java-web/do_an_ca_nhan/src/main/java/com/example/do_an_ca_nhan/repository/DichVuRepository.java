package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.dto.DichVuDTO;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DichVuRepository implements IDichVuRepository {

    private final String SELECT_ALL = "SELECT * FROM dich_vu";
    private final String INSERT_SQL = "INSERT INTO dich_vu (ten_dich_vu, dien_tich, chi_phi_thue, so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong, mo_ta_tien_nghi_khac, dien_tich_ho_boi, so_tang) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final String FIND_BY_ID = "SELECT * FROM dich_vu WHERE ma_dich_vu = ?";
    private final String UPDATE_SQL = "UPDATE dich_vu SET ten_dich_vu = ?, dien_tich = ?, chi_phi_thue = ?, so_nguoi_toi_da = ?, ma_kieu_thue = ?, ma_loai_dich_vu = ?, tieu_chuan_phong = ?, mo_ta_tien_nghi_khac = ?, dien_tich_ho_boi = ?, so_tang = ? WHERE ma_dich_vu = ?";
    private final String DELETE_SQL = "DELETE FROM dich_vu WHERE ma_dich_vu = ?";

    @Override
    public List<DichVuDTO> findAll() {
        List<DichVuDTO> list = new ArrayList<>();
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                DichVuDTO dv = new DichVuDTO(
                        rs.getInt("ma_dich_vu"),
                        rs.getString("ten_dich_vu"),
                        rs.getInt("dien_tich"),
                        rs.getDouble("chi_phi_thue"),
                        rs.getInt("so_nguoi_toi_da"),
                        rs.getInt("ma_kieu_thue"),
                        rs.getInt("ma_loai_dich_vu"),
                        rs.getString("tieu_chuan_phong"),
                        rs.getString("mo_ta_tien_nghi_khac"),
                        rs.getDouble("dien_tich_ho_boi"),
                        rs.getInt("so_tang")
                );
                list.add(dv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean add(DichVuDTO dv) {
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_SQL)) {
            stmt.setString(1, dv.getTenDichVu());
            stmt.setInt(2, dv.getDienTich());
            stmt.setDouble(3, dv.getChiPhiThue());
            stmt.setInt(4, dv.getSoNguoiToiDa());
            stmt.setInt(5, dv.getMaKieuThue());
            stmt.setInt(6, dv.getMaLoaiDichVu());
            stmt.setString(7, dv.getTieuChuanPhong());
            stmt.setString(8, dv.getMoTaTienNghiKhac());
            stmt.setDouble(9, dv.getDienTichHoBoi());
            stmt.setInt(10, dv.getSoTang());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public DichVuDTO findById(int id) {
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new DichVuDTO(
                        rs.getInt("ma_dich_vu"),
                        rs.getString("ten_dich_vu"),
                        rs.getInt("dien_tich"),
                        rs.getDouble("chi_phi_thue"),
                        rs.getInt("so_nguoi_toi_da"),
                        rs.getInt("ma_kieu_thue"),
                        rs.getInt("ma_loai_dich_vu"),
                        rs.getString("tieu_chuan_phong"),
                        rs.getString("mo_ta_tien_nghi_khac"),
                        rs.getDouble("dien_tich_ho_boi"),
                        rs.getInt("so_tang")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(DichVuDTO dv) {
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_SQL)) {
            stmt.setString(1, dv.getTenDichVu());
            stmt.setInt(2, dv.getDienTich());
            stmt.setDouble(3, dv.getChiPhiThue());
            stmt.setInt(4, dv.getSoNguoiToiDa());
            stmt.setInt(5, dv.getMaKieuThue());
            stmt.setInt(6, dv.getMaLoaiDichVu());
            stmt.setString(7, dv.getTieuChuanPhong());
            stmt.setString(8, dv.getMoTaTienNghiKhac());
            stmt.setDouble(9, dv.getDienTichHoBoi());
            stmt.setInt(10, dv.getSoTang());
            stmt.setInt(11, dv.getMaDichVu());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(int id) {
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_SQL)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
