package com.store.UserService.controllers;


import Mapper.Mapper;
import com.store.UserService.dtos.*;
import com.store.UserService.exception.UserAlreadyExistsException;
import com.store.UserService.exception.UserDoesNotFoundException;
import com.store.UserService.models.SessionStatus;
import com.store.UserService.models.User;
import com.store.UserService.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/signup")
    public ResponseEntity<LoginResponseDTO> signup(@RequestBody SignupRequestDTO signUpRequestDTO) throws UserAlreadyExistsException {
        User user = userService.registerUser(Mapper.toUser(signUpRequestDTO));
        return new ResponseEntity<>(Mapper.toLoginResponseDTO(user), HttpStatus.ACCEPTED);
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) throws UserDoesNotFoundException {

        return userService.login(loginRequestDTO.getUsername(), loginRequestDTO.getPassword());
    }

    @PostMapping("/validateToken")
    public ResponseEntity<ValidateTokenResponseDTO> validateToken(@RequestBody ValidateTokenRequestDTO request) throws UserDoesNotFoundException {



            Optional<UserDTO> userDTO = userService.validateToken(request.getUserId(), request.getToken());

            if(userDTO.isEmpty()){
                ValidateTokenResponseDTO responseDTO = new ValidateTokenResponseDTO();
                responseDTO.setSessionStatus(SessionStatus.INVALID);
                return new ResponseEntity<>(responseDTO,HttpStatus.OK);
            }

            ValidateTokenResponseDTO response = new ValidateTokenResponseDTO();
            response.setSessionStatus(SessionStatus.ACTIVE);
            response.setUserDTO(userDTO.get());

            return new ResponseEntity<>(response, HttpStatus.OK);

    }



    // Logout Endpoint
    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        userService.logout();
        return ResponseEntity.ok("User logged out successfully");
    }
}

