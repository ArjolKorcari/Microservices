package com.microservice.UserMicroserviceApplication.Service;

import com.microservice.UserMicroserviceApplication.dto.UserRequestDto;
import com.microservice.UserMicroserviceApplication.dto.UserResponseDto;
import com.microservice.UserMicroserviceApplication.models.User;
import com.microservice.UserMicroserviceApplication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(user -> new UserResponseDto(user.getName(), user.getSurname(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public User createUser(UserRequestDto user) {

        User userToSave = new User(user.name(),user.surname(),user.email(), user.password());
        return userRepository.save(userToSave);
    }
}
