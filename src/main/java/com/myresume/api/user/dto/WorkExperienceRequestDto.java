package com.myresume.api.user.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class WorkExperienceRequestDto {
    private Long userId;
    @NotNull(message = "CompanyName can not be null")
    @Size(min = 2, message = "CompanyName must be less than two characters")
    private String companyName;
    @NotNull(message = "PositionTitle can not be null")
    @Size(min = 2, message = "PositionTitle must be less than two characters")
    private String positionTitle;
    @NotNull(message = "EmploymentType can not be null")
    @Size(min = 2, message = "EmploymentType must be less than two characters")
    private String employmentType;
    private String description;
    private String toolAndTechnology;
    private String country;
    private String city;
    @NotNull(message = "StartDate can not be null")
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
