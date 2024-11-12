package com.store.UserService.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "carts")
public class Cart extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Link to the user

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> items; // List of items in the cart

    // Getters and Setters...
}
