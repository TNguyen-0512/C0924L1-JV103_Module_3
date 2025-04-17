package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.TrinhDo;
import com.example.do_an_ca_nhan.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoRepository implements ITrinhDoRepository {
    private static final String SELECT_ALL = "SELECT * FROM trinh_do";

    @Override
    public List<TrinhDo> findAll() {
        List<TrinhDo> list = new ArrayList<>();
        try (
                Connection connection = BaseRepository.getConnection();
                PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
                ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                TrinhDo td = new TrinhDo();
                td.setMaTrinhDo(rs.getInt("ma_trinh_do"));
                td.setTenTrinhDo(rs.getString("ten_trinh_do"));
                list.add(td);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
