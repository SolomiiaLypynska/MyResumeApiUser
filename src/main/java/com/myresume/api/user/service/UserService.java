package com.myresume.api.user.service;

import com.myresume.api.user.dto.UpdateUserRequestDto;
import com.myresume.api.user.entity.User;
import com.myresume.api.user.dto.CreateUserRequestDto;
import com.myresume.api.user.dto.ProfileUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    ProfileUserDto createUser(CreateUserRequestDto dto);

    User getUserByEmail(String email);

    ProfileUserDto getUserById(Long id);

    ProfileUserDto update(Long id, UpdateUserRequestDto dto);
}
