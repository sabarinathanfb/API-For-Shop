package com.store.UserService.dtos;

public class CartItemDTO {
    private Long id;
    private ProductDTO product; // Product information fetched from the Product Service
    private Integer quantity;
    private Double priceAtAddition;

    // Getters and Setters...
}

