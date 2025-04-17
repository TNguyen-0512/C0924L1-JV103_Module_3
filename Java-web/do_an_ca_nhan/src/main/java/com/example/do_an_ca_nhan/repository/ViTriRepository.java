package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.ViTri;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViTriRepository implements IViTriRepository{
    private final String FIND_ALL = "select * from vi_tri";
    Connection conn = BaseRepository.getConnection();
    @Override
    public List<ViTri> findAll() {
        List<ViTri> viTriList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ViTri viTri = new ViTri();
                viTri.setMaViTri(rs.getInt(1));
                viTri.setTenViTri(rs.getString(2));
               viTriList.add(viTri);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return viTriList;
    }
}
