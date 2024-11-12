package Mapper;

import com.store.UserService.dtos.LoginRequestDTO;
import com.store.UserService.dtos.LoginResponseDTO;
import com.store.UserService.dtos.SignupRequestDTO;
import com.store.UserService.models.User;

public class Mapper {

    public static User toUser(SignupRequestDTO signUpRequestDTO){

        return User.builder()
                .username(signUpRequestDTO.getUsername())
                .email(signUpRequestDTO.getEmail())
                .password(signUpRequestDTO.getPassword())
                .build();

    }

    public static User toUser(LoginRequestDTO loginRequestDTO){

        return User.builder()
                .username(loginRequestDTO.getUsername())
                .email(loginRequestDTO.getEmail())
                .password(loginRequestDTO.getPassword())
                .build();

    }

    public static LoginResponseDTO toLoginResponseDTO(User user){

        return LoginResponseDTO.builder()
                .username(user.getUsername())
                .build();
    }
}
