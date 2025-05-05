package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.dto.DichVuDTO;
import com.example.do_an_ca_nhan.repository.DichVuRepository;

import java.util.List;

public class DichVuService implements IDichVuService {
    private DichVuRepository repository = new DichVuRepository();

    @Override
    public List<DichVuDTO> findAll() {
        return repository.findAll();
    }

    @Override
    public boolean add(DichVuDTO dichVu) {
        return repository.add(dichVu);
    }

    @Override
    public DichVuDTO findById(int id) {
        return repository.findById(id);
    }

    @Override
    public boolean update(DichVuDTO dichVu) {
        return repository.update(dichVu);
    }

    @Override
    public boolean delete(int id) {
        return repository.delete(id);
    }
}
