package com.example.demo.entities;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MenuItemCondition {
    private Integer threshold;
    private String comparison;
    private String message;
    private String messageIfTrue;
    private String messageIfFalse;

}
