package com.myresume.api.user.service.implementation;

import com.myresume.api.user.dto.CreateUserRequestDto;
import com.myresume.api.user.dto.ProfileUserDto;
import com.myresume.api.user.dto.UpdateUserRequestDto;
import com.myresume.api.user.entity.User;
import com.myresume.api.user.entity.WorkExperience;
import com.myresume.api.user.exception.exception_type.NotFoundException;
import com.myresume.api.user.mapper.CreateUserRequestMapper;
import com.myresume.api.user.mapper.ProfileUserMapper;
import com.myresume.api.user.repository.UserRepository;
import com.myresume.api.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private CreateUserRequestMapper createUserRequestMapper;

    @Autowired
    private ProfileUserMapper profileUserMapper;

    @Override
    public ProfileUserDto createUser(CreateUserRequestDto dto) {
        log.info("Started create new User: {};", dto);
        dto.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        User user = createUserRequestMapper.toEntity(dto);
        userRepository.save(user);
        log.info("Successfully created new User;");
        return profileUserMapper.toDto(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return Optional.ofNullable(user)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getEmail(),
                        u.getPassword(),
                        true, true, true, true,
                        new ArrayList<>()
                ))
                .orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public User getUserByEmail(String email) {
        Optional<User> user = Optional.ofNullable(userRepository.findByEmail(email));
        return user.orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public ProfileUserDto getUserById(Long id) {
        log.info("Started getting ProfileUserDto by userId: {};", id);
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found User by id: " + id));
        List<WorkExperience> sortedWorks = user.getWorkExperiences().stream()
                .sorted(Comparator.comparing(WorkExperience::getStartDate).reversed())
                .toList();
        user.setWorkExperiences(sortedWorks);
        ProfileUserDto dto = profileUserMapper.toDto(user);
        log.info("Successfully getting ProfileUserDto: {} by userId: {};",dto, id);
        return dto;
    }

    @Override
    public ProfileUserDto update(Long id, UpdateUserRequestDto dto) {
        log.info("Started updating User by userId: {};", id);
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found User by id: " + id));
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        userRepository.save(user);
        log.info("Successfully update User by userId: {};", id);
        return profileUserMapper.toDto(user);
    }
}
