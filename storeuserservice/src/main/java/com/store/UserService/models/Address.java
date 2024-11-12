package com.store.UserService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "addresses")
@Getter
@Setter
public class Address extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // Link to the user

    private String street;
    private String city;
    private String state;
    private String country;
    private String postalCode;


}
