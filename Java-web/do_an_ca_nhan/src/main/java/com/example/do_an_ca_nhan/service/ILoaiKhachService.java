package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.model.LoaiKhach;

import java.util.List;

public interface ILoaiKhachService {
    List<LoaiKhach> findAll();
    String findNameById(int id);
}
