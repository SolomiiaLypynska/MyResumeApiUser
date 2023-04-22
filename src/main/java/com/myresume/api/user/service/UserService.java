package com.myresume.api.user.service;

import com.myresume.api.user.entity.User;
import com.myresume.api.user.dto.CreateUserDto;
import com.myresume.api.user.dto.ProfileUserDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    CreateUserDto createUser(CreateUserDto userModel);

    User getUserByEmail(String email);

    ProfileUserDto getUserById(Long id);
}
