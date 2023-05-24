package com.myresume.api.user.service;

import com.myresume.api.user.dto.WorkExperienceRequestDto;
import com.myresume.api.user.dto.WorkExperienceResponseDto;

public interface WorkExperienceService {

    WorkExperienceRequestDto addWorkExperience(WorkExperienceRequestDto dto);
    WorkExperienceResponseDto getWorkExperienceById(Long id);
}
