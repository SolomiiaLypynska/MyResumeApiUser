package com.myresume.api.user.controller;

import com.myresume.api.user.dto.CreateUserRequestDto;
import com.myresume.api.user.dto.ProfileUserDto;
import com.myresume.api.user.dto.UpdateUserRequestDto;
import com.myresume.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${token.secret:}")
    private String tokenSecret;

    @PostMapping(path = {"/signup"}, consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProfileUserDto> create(@Valid @RequestBody CreateUserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @PutMapping(path = "/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProfileUserDto> update(@PathVariable Long id,
                                                 @RequestBody UpdateUserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.update(id, dto));
    }

    @GetMapping(path = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProfileUserDto> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }
}
