package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.dto.NhanVienDTO;
import com.example.do_an_ca_nhan.model.NhanVien;

import java.util.List;

public interface INhanVienRepository {
    List<NhanVienDTO> findAll();
    List<NhanVienDTO> findByName(String name);
    NhanVienDTO findDTOById(int id);
    NhanVien findById(int id);
    boolean add(NhanVien nhanVien);
    boolean update(NhanVien nhanVien);
    boolean delete(int id);
}
