package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class CreateUserDto {
    @NotNull(message = "FirstName can not be null")
    @Size(min = 2, message = "FirstName must be less than two characters")
    private String firstName;
    @NotNull(message = "LastName can not be null")
    @Size(min = 2, message = "LastName must be less than two characters")
    private String lastName;
    @NotNull(message = "Password can not be null")
    @Size(min = 4, max = 16, message = "Password must be equal or grater than 2 characters and less than 16 characters")
    private String password;
    @NotNull(message = "Email can not be null")
    @Email
    private String email;
    @NotNull(message = "Role can not be null")
    private String role;
}
