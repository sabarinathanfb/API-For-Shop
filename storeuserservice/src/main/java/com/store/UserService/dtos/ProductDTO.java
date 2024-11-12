package com.store.UserService.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private Long id;
    private String name;
    private Double price;
    private String description;

}

