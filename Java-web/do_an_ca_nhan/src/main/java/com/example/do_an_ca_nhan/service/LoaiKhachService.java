package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.model.LoaiKhach;
import com.example.do_an_ca_nhan.repository.ILoaiKhachRepository;
import com.example.do_an_ca_nhan.repository.LoaiKhachRepository;

import java.util.List;

public class LoaiKhachService implements ILoaiKhachService {
    private ILoaiKhachRepository repository=new LoaiKhachRepository();
    @Override
    public List<LoaiKhach> findAll() {
        return repository.findAll();
    }

    @Override
    public String findNameById(int id) {
        return repository.findNameById(id);
    }
}
