package com.myresume.api.user.service;

import com.myresume.api.user.dto.WorkExperienceDto;

public interface WorkExperienceService {

    WorkExperienceDto addWorkExperience(WorkExperienceDto dto);
    WorkExperienceDto getWorkExperienceById(Long id);
}
