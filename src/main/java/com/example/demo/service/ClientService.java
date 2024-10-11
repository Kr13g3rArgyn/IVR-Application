package com.example.demo.service;

import com.example.demo.entities.ClientEntity;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MenuItemRepository;
import com.example.demo.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final MenuRepository menuRepository;
    private final ClientRepository clientRepository;
    private final MenuItemRepository itemRepository;

    @Autowired
    public ClientService(MenuRepository menuRepository, ClientRepository clientRepository, MenuItemRepository itemRepository) {
        this.menuRepository = menuRepository;
        this.clientRepository = clientRepository;
        this.itemRepository = itemRepository;
    }

    private List<ClientEntity> getClient(){
        return clientRepository.findAll();
    }


}
