package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.model.BoPhan;
import com.example.do_an_ca_nhan.repository.BoPhanRepository;
import com.example.do_an_ca_nhan.repository.IBoPhanRepository;

import java.util.List;


public class BoPhanService implements IBoPhanService {
    private IBoPhanRepository repository = new BoPhanRepository();

    @Override
    public List<BoPhan> findAll() {
        return repository.findAll();
    }
}
