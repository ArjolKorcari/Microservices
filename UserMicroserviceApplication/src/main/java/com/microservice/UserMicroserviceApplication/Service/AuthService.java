package com.microservice.UserMicroserviceApplication.Service;

import com.microservice.UserMicroserviceApplication.dto.LoginRequest;
import com.microservice.UserMicroserviceApplication.dto.UserResponseDto;
import com.microservice.UserMicroserviceApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;


    public UserResponseDto login(LoginRequest loginRequest){

        var user = userRepository.findByEmail(loginRequest.email());
        if (user.isPresent()){
            if(user.get().getPassword().equals(loginRequest.password())){
            return new UserResponseDto(user.get().getName(),user.get().getSurname(),user.get().getEmail());
            }else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new IllegalArgumentException("User not found");
        }
    }




}
