package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.dto.NhanVienDTO;
import com.example.do_an_ca_nhan.model.NhanVien;
import com.example.do_an_ca_nhan.repository.INhanVienRepository;
import com.example.do_an_ca_nhan.repository.NhanVienRepository;

import java.util.List;

public class NhanVienService implements INhanVienService {
    private INhanVienRepository repo=new NhanVienRepository();
    @Override
public List<NhanVienDTO> findAll() {
        return repo.findAll();
    }

    @Override
    public List<NhanVienDTO> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public NhanVienDTO findDTOById(int id) {
        return repo.findDTOById(id);
    }

    @Override
    public NhanVien findById(int id) {
        return repo.findById(id);
    }

    @Override
    public boolean add(NhanVien nhanVien) {
        return repo.add(nhanVien);
    }

    @Override
    public boolean update(NhanVien nhanVien) {
        return repo.update(nhanVien);
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }
}
