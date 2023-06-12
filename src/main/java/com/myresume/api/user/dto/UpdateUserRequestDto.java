package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UpdateUserRequestDto {
    private String firstName;
    private String lastName;
}
