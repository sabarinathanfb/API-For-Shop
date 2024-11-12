package com.store.UserService.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDTO {

    private String username;
    private String password;
    private String email;

}
