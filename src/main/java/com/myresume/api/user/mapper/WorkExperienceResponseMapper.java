package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.WorkExperienceResponseDto;
import com.myresume.api.user.entity.WorkExperience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkExperienceResponseMapper extends SuperMapper<WorkExperience, WorkExperienceResponseDto> {
    WorkExperience toEntity(WorkExperienceResponseDto dto);

    @Mapping(source = "user.userId", target = "userId")
    WorkExperienceResponseDto toDto(WorkExperience workExperience);
}
