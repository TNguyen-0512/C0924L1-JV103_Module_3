package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.LoaiKhach;

import java.util.List;

public interface ILoaiKhachRepository {
    List<LoaiKhach> findAll();
    String findNameById(int id);
}
