package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.WorkExperienceResponseDto;
import com.myresume.api.user.entity.WorkExperience;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkExperienceResponseDtoMapper extends SuperMapper<WorkExperience, WorkExperienceResponseDto> {
    WorkExperience toEntity(WorkExperienceResponseDto dto);

    WorkExperienceResponseDto toDto(WorkExperience workExperience);
}
