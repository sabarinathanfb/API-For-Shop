package com.store.UserService.models;


import com.store.UserService.models.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Entity

@Getter
@Setter
@Builder
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String username;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Cart> carts;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private Boolean status;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;


}

