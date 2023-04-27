package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProfileUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role;
}
