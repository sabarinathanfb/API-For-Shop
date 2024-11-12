package com.store.UserService.services;


import com.store.UserService.dtos.LoginResponseDTO;

import com.store.UserService.dtos.UserDTO;
import com.store.UserService.exception.UserAlreadyExistsException;
import com.store.UserService.exception.UserDoesNotFoundException;
import com.store.UserService.models.Session;
import com.store.UserService.models.SessionStatus;
import com.store.UserService.models.User;
import com.store.UserService.repositories.SessionRepository;
import com.store.UserService.repositories.UserRepository;
import com.store.UserService.security.JwtUtil;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


import java.util.HashMap;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final SessionRepository sessionRepository;

    public UserService(SessionRepository sessionRepository,UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.sessionRepository = sessionRepository;
    }

    public User registerUser(User user) throws UserAlreadyExistsException {

        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());
        if(userOptional.isPresent()){
            throw new UserAlreadyExistsException("User with" + user.getEmail() + "already Exists");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public ResponseEntity<LoginResponseDTO> login(String username, String password) throws UserDoesNotFoundException {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isEmpty()) {

            throw new UserDoesNotFoundException("Username " + username + " Does Not Exist");

        }

        if (!passwordEncoder.matches(password, userOptional.get().getPassword())) {
            throw new UserDoesNotFoundException("Username " + username + " Password Does Not Match");
        }

        String token = JwtUtil.generateToken(username);

        Session session = new Session();
        session.setToken(token);
        session.setSessionstatus(SessionStatus.ACTIVE);
        session.setUser(userOptional.get());
        sessionRepository.save(session);


        // Instead of using a custom header, we set the token in the Authorization header
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token); // Set the Authorization header


        return new ResponseEntity<>(LoginResponseDTO.builder()
                .userId(userOptional.get().getId())
                .username(userOptional.get().getUsername())
                .build(),headers, HttpStatus.OK);

    }

    public Optional<UserDTO> validateToken(Long userId, String token) throws UserDoesNotFoundException {


        Optional<Session> sessionOptional = sessionRepository.findByTokenAndUser_Id(token, userId);

        if(sessionOptional.isEmpty()){
            return Optional.empty();
        }

        Session session = sessionOptional.get();

        if(!session.getSessionstatus().equals(SessionStatus.ACTIVE)){
            return Optional.empty();
        }

        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isEmpty()) {
            throw new UserDoesNotFoundException("User with ID " + userId + " does not exist");
        }

        return Optional.of(UserDTO.builder()
                .userId(userOptional.get().getId())
                .username(userOptional.get().getUsername())
                .email(userOptional.get().getEmail())
                .build());

    }









    public void logout() {
        // Implement logout logic (if using JWT or session management)
    }
}

