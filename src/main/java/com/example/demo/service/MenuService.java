package com.example.demo.service;

import com.example.demo.components.MappingComponent;
import com.example.demo.dto.ClientDTO;
import com.example.demo.entities.ClientEntity;
import com.example.demo.entities.Menu;
import com.example.demo.entities.MenuItem;
import com.example.demo.entities.MenuItemCondition;
import com.example.demo.repositories.ClientRepository;
import com.example.demo.repositories.MenuItemRepository;
import com.example.demo.repositories.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;
    private MenuItemRepository menuItemRepository;
    private MappingComponent mappingComponent;
    private ClientRepository clientRepository;

    public Menu getMainMenu(){
        return menuRepository.findById(1L).
                orElseThrow(() -> new RuntimeException("Menu not found"));
    }

    public String processMenuSelection(Long menuId, ClientDTO clientDTO){

        ClientEntity clientEntity = mappingComponent.convertClientDtoToEntity(clientDTO);
        clientRepository.save(clientEntity);

        Optional<MenuItem> menuItem = menuItemRepository.findById(menuId);
        if (menuItem.isEmpty()) {
            return "Неверный выбор. Пожалуйста повторите ввод!";
        }

        MenuItem item = menuItem.get();
        StringBuilder response = new StringBuilder();

        if (item.getCondition() != null && !evaluateCondition(item.getCondition(), clientDTO)) {
            response.append(item.getCondition().getMessageIfFalse());
        } else {
            response.append(item.getMessage());
        }

        return response.toString();
    }

    private boolean evaluateCondition(MenuItemCondition condition, ClientDTO clientDTO) {
        return switch (condition.getComparison()) {
            case "LESS_THAN" -> clientDTO.getBalance() < condition.getThreshold();
            case "GREATER_THAN" -> clientDTO.getBalance() > condition.getThreshold();
            case "EQUALS" -> clientDTO.getBalance().equals(condition.getThreshold());
            default -> false;
        };
    }
}
