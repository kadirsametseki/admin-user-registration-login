package com.example.adminuserregistrationlogin.service;

import com.example.adminuserregistrationlogin.dto.request.SaveUserRequest;
import com.example.adminuserregistrationlogin.dto.response.UserDto;
import com.example.adminuserregistrationlogin.model.User;
import com.example.adminuserregistrationlogin.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDto save(SaveUserRequest request) {
        User user = new User(request.getEmail(), passwordEncoder.encode(request.getPassword()) , request.getRole(), request.getFullname());
        userRepository.save(user);
        return new UserDto(user.getId(), user.getEmail(), user.getPassword(), user.getRole(), user.getFullname());
    }
}