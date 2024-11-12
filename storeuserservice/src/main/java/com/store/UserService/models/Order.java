package com.store.UserService.models;
import com.store.UserService.models.enums.OrderStatus;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Double totalAmount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<ProductOrder> products; // List of products in the order

    @OneToOne
    private Address shippingAddress;

    @OneToOne
    private Address billingAddress;

    private String paymentStatus;


}

