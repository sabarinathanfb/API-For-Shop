package com.store.UserService.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Session extends BaseEntity{

    private String token;
    private Date expiringAt;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.ORDINAL)
    private SessionStatus Sessionstatus;

}
