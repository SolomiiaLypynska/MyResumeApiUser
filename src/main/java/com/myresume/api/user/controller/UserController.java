package com.myresume.api.user.controller;

import com.myresume.api.user.dto.CreateUserDto;
import com.myresume.api.user.dto.ProfileUserDto;
import com.myresume.api.user.entity.User;
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

    @GetMapping("/status/check")
    public String status() {

        return "Working " + tokenSecret;
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<ProfileUserDto> find(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CreateUserDto> create(@Valid @RequestBody CreateUserDto userRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userRequestModel));
    }
}
