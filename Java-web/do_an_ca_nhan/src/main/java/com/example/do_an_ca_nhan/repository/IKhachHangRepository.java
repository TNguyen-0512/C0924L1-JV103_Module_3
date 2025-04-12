package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.KhachHang;

import java.util.List;

public interface IKhachHangRepository {
    List<KhachHang> findAll();
    boolean add(KhachHang khachHang);
    boolean update(KhachHang khachHang);
    boolean delete(int id);
    List<KhachHang> findByName(String name);
    KhachHang findById(int id);
}
