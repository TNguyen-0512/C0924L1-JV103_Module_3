package com.example.do_an_ca_nhan.repository;

import com.example.do_an_ca_nhan.model.BoPhan;


import java.util.List;

public interface IBoPhanRepository {
    List<BoPhan> findAll();
}
