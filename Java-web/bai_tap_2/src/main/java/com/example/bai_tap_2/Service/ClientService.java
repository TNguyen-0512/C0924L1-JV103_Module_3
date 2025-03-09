package com.example.bai_tap_2.Service;

import com.example.bai_tap_2.model.Client;
import com.example.bai_tap_2.repository.ClientRepository;
import com.example.bai_tap_2.repository.IClientRepository;

import java.util.List;

public class ClientService implements IClientService {

    private IClientRepository clientRepository= new ClientRepository();
    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }
}
