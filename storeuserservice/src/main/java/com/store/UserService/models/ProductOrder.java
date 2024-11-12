package com.store.UserService.models;

import com.store.UserService.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "product_orders")
public class ProductOrder extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "product_id")
    private Long productId; // Link to the product

    private Integer quantity; // Quantity of the product ordered

    private Double priceAtPurchase; // Price at the time of purchase

    // Getters and Setters...
}
