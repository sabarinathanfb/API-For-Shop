package com.store.UserService.dtos;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LoginResponseDTO {

    private Long userId;
    private String username;

}
