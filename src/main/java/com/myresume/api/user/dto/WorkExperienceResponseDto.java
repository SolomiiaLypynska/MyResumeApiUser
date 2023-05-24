package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WorkExperienceResponseDto {
    private Long workExperienceId;
    private Long userId;
    private String companyName;
    private String positionTitle;
    private String employmentType;
    private String description;
    private String toolAndTechnology;
    private String country;
    private String city;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
