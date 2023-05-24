package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.WorkExperienceRequestDto;
import com.myresume.api.user.entity.WorkExperience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkExperienceRequestMapper extends SuperMapper<WorkExperience, WorkExperienceRequestDto> {
    WorkExperience toEntity(WorkExperienceRequestDto dto);

    WorkExperienceRequestDto toDto(WorkExperience workExperience);
}
