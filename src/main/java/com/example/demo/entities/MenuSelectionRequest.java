package com.example.demo.entities;

import com.example.demo.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MenuSelectionRequest {
    private Long menuItemId;
    private ClientDTO clientDTO;
}
