package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.model.ViTri;
import com.example.do_an_ca_nhan.repository.ViTriRepository;

import java.util.List;

public class ViTriService implements IViTriService{
    private ViTriRepository repository = new ViTriRepository();

    @Override
    public List<ViTri> findAll() {
        return repository.findAll();
    }
}
