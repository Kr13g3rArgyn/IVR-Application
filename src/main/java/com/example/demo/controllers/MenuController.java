package com.example.demo.controllers;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entities.MenuItem;
import com.example.demo.entities.MenuRequest;
import com.example.demo.entities.MenuSelectionRequest;
import com.example.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/main")
    public List<MenuItem> getMainMenu(){
        return List.copyOf(menuService.getMainMenu().getItems());
    }
    @PostMapping("/select/{menuId}")
    public String processMenuSelection(@PathVariable Long menuId, @RequestBody ClientDTO clientDTO) {
        return menuService.processMenuSelection(menuId, clientDTO);
    }
}
