package com.example.adminuserregistrationlogin.service;

import com.example.adminuserregistrationlogin.dto.request.SaveUserRequest;
import com.example.adminuserregistrationlogin.dto.response.UserDto;

public interface UserService {
    UserDto save(SaveUserRequest request);
}
