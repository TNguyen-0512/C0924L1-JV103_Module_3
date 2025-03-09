package com.example.bai_tap_2.repository;

import com.example.bai_tap_2.model.Client;

import java.util.List;

public interface IClientRepository {
    List<Client> findAll();
}
