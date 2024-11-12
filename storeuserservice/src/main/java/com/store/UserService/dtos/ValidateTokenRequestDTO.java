package com.store.UserService.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenRequestDTO {

    private Long userId;
    private String token;


}
