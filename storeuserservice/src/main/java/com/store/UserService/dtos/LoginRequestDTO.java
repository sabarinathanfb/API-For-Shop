package com.store.UserService.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginRequestDTO {

    private String username;
    private String email;
    private String password;
}
