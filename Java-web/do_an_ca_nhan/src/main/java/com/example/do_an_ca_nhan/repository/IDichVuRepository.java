package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.dto.DichVuDTO;

import java.util.List;

public interface IDichVuRepository {
    List<DichVuDTO> findAll();
    boolean add(DichVuDTO dichVu);
    DichVuDTO findById(int id);
    boolean update(DichVuDTO dichVu);
    boolean delete(int id);
}
