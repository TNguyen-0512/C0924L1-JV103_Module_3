package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.model.KhachHang;
import com.example.do_an_ca_nhan.repository.IKhachHangRepository;
import com.example.do_an_ca_nhan.repository.KhachHangRepository;

import java.util.List;

public class KhachHangService implements IKhachHangService {
    private IKhachHangRepository repo = new KhachHangRepository();
    @Override
    public List<KhachHang> findAll() {
        return repo.findAll();
    }

    @Override
    public boolean add(KhachHang khachHang) {
        return repo.add(khachHang);
    }

    @Override
    public boolean update(KhachHang khachHang) {
        return repo.update(khachHang);
    }

    @Override
    public boolean delete(int id) {
        return repo.delete(id);
    }

    @Override
    public List<KhachHang> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public KhachHang findById(int id) {
        return repo.findById(id);
    }
}
