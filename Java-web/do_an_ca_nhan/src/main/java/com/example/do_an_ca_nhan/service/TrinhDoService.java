package com.example.do_an_ca_nhan.service;

import com.example.do_an_ca_nhan.model.TrinhDo;
import com.example.do_an_ca_nhan.repository.ITrinhDoRepository;
import com.example.do_an_ca_nhan.repository.TrinhDoRepository;

import java.util.List;

public class TrinhDoService implements ITrinhDoService {
    private ITrinhDoRepository trinhDoRepository = new TrinhDoRepository();
    @Override
    public List<TrinhDo> findAll() {
        return trinhDoRepository.findAll();
    }
}
