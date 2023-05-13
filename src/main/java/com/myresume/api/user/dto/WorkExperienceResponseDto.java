package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WorkExperienceResponseDto {
    private Long workExperienceId;
    private String positionTitle;
}
