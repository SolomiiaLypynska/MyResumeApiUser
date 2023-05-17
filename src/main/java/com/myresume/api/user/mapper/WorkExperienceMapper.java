package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.WorkExperienceDto;
import com.myresume.api.user.entity.WorkExperience;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface WorkExperienceMapper extends SuperMapper<WorkExperience, WorkExperienceDto> {
    WorkExperience toEntity(WorkExperienceDto dto);

    @Mapping(source = "user.userId", target = "userId")
    WorkExperienceDto toDto(WorkExperience workExperience);
}
