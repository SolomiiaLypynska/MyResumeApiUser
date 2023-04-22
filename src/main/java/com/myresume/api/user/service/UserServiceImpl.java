package com.myresume.api.user.service;

import com.myresume.api.user.dto.CreateUserDto;
import com.myresume.api.user.dto.ProfileUserDto;
import com.myresume.api.user.entity.User;
import com.myresume.api.user.mapper.CreateUserMapper;
import com.myresume.api.user.mapper.ProfileUserMapper;
import com.myresume.api.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CreateUserMapper createUserMapper;

    @Autowired
    private ProfileUserMapper profileUserMapper;

    @Override
    public CreateUserDto createUser(CreateUserDto dto) {
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        User user = createUserMapper.toEntity(dto);
        userRepository.save(user);
        return dto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        user.orElseThrow(() -> new UsernameNotFoundException(email));
        return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), true, true, true, true, new ArrayList<>());
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.orElseThrow(() -> new UsernameNotFoundException(email));
    }

    //TODO return custom Exception
    @Override
    public ProfileUserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException());
        return profileUserMapper.toDto(user);
    }
}
