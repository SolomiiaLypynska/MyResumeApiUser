package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;
}
