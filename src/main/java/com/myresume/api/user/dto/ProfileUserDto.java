package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProfileUserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private List<WorkExperienceDto> workExperiences;
}
