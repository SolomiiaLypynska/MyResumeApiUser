package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.ProfileUserDto;
import com.myresume.api.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileUserMapper extends SuperMapper<User, ProfileUserDto> {
    User toEntity(ProfileUserDto dto);

    ProfileUserDto toDto(User user);
}
