package com.example.demo.components;

import com.example.demo.dto.ClientDTO;
import com.example.demo.entities.ClientEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MappingComponent {
    private final ModelMapper modelMapper;
    public MappingComponent(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }
    public ClientEntity convertClientDtoToEntity(ClientDTO clientDTO){
        return modelMapper.map(clientDTO, ClientEntity.class);
    }
    public ClientDTO convertClientToDTO(ClientEntity clientEntity){
        return modelMapper.map(clientEntity, ClientDTO.class);
    }

}
