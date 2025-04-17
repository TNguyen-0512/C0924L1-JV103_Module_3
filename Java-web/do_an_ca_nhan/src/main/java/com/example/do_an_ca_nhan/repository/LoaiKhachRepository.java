package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.LoaiKhach;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiKhachRepository implements ILoaiKhachRepository {
    private static final String SELECT_ALL = "SELECT * FROM loai_khach";
    private final String FIND_NAME_BY_ID = "SELECT ten_loai_khach FROM loai_khach WHERE ma_loai_khach = ?";
    Connection conn = BaseRepository.getConnection();
    @Override
    public String findNameById(int id) {
        try (PreparedStatement ps = conn.prepareStatement(FIND_NAME_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("ten_loai_khach");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public List<LoaiKhach> findAll() {
        List<LoaiKhach> list = new ArrayList<>();
        try (Connection conn = BaseRepository.getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiKhach loaiKhach = new LoaiKhach();
                loaiKhach.setMaLoaiKhach(rs.getInt("ma_loai_khach"));
                loaiKhach.setTenLoaiKhach(rs.getString("ten_loai_khach"));
                list.add(loaiKhach);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
