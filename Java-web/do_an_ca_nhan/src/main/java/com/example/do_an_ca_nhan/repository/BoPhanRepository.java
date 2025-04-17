package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.BoPhan;
import com.example.do_an_ca_nhan.model.ViTri;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoPhanRepository implements IBoPhanRepository {
    private final String FIND_ALL = "select * from bo_phan";
    Connection conn = BaseRepository.getConnection();
    @Override
    public List<BoPhan> findAll() {
        List<BoPhan> boPhanList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BoPhan boPhan = new BoPhan();
               boPhan.setMaBoPhan(rs.getInt("ma_bo_phan"));
               boPhan.setTenBoPhan(rs.getString("ten_bo_phan"));
                boPhanList.add(boPhan);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return boPhanList;
    }
}
