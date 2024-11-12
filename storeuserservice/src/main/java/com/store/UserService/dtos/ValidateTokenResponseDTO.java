package com.store.UserService.dtos;

import com.store.UserService.models.SessionStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateTokenResponseDTO {
    private UserDTO userDTO;
    private SessionStatus sessionStatus;



}
