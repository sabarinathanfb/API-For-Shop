package com.store.UserService.dtos;


import com.store.UserService.models.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserDTO {

    private Long userId;
    private String username;
    private String email;



}
