package com.example.bai_tap_2.repository;

import com.example.bai_tap_2.model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository implements IClientRepository {
    private static List<Client> clients = new ArrayList<>();
    static {
        clients.add(new Client(1,"Bùi Trung Nguyên", LocalDate.of(2003,12,05),"Gia Lai","images/hinhanh.jpg"));
        clients.add(new Client(2,"Đặng Ngọc Hoàng Thái", LocalDate.of(2003,12,16),"Gia Lai","images/hinhanh.jpg"));
        clients.add(new Client(3,"Huỳnh Nhân", LocalDate.of(2003,04,15),"Gia Lai","images/hinhanh.jpg"));
    }

    @Override
    public List<Client> findAll() {
        return clients;
    }
}
