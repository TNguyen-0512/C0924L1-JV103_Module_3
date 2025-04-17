package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.dto.KhachHangDTO;
import com.example.do_an_ca_nhan.model.KhachHang;

import java.util.List;

public interface IKhachHangRepository {
    List<KhachHangDTO> findAll();
    boolean add(KhachHangDTO khachHang);
    boolean update(KhachHangDTO khachHang);
    boolean delete(int id);
    List<KhachHangDTO> findByName(String name);
    KhachHangDTO findById(int id);
}
