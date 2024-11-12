package com.store.UserService.models;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "roles")
public class Role extends BaseEntity {

    private String name; // Role name, e.g., ADMIN, CUSTOMER
    private String description; // Role description

    // Getters and Setters...
}
