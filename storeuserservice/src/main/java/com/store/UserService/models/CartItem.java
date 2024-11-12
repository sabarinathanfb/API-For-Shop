package com.store.UserService.models;

import com.store.UserService.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "cart_items")
public class CartItem extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart; // Link to the cart

    @Column(name = "product_id")
    private Long productId;

    private Integer quantity; // Quantity of the product in the cart

    private Double priceAtAddition; // Price when the product was added to the cart


}

