package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.dto.DichVuDTO;

import java.util.List;

public interface IDichVuService {
    List<DichVuDTO> findAll();
    boolean add(DichVuDTO dichVu);
    DichVuDTO findById(int id);
    boolean update(DichVuDTO dichVu);
    boolean delete(int id);
}
