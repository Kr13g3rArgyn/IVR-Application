package com.example.demo.service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class ClientService {

    private final MenuRepository menuRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(MenuRepository menuRepository, ClientRepository clientRepository) {
        this.menuRepository = menuRepository;
        this.clientRepository = clientRepository;
    }

    private List<ClientEntity> getClient(){
        return clientRepository.findAll();
    }


}
