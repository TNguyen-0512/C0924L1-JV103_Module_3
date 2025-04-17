package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.TrinhDo;

import java.util.List;

public interface ITrinhDoRepository {
    List<TrinhDo> findAll();
}
