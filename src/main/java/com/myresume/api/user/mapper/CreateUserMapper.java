package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.CreateUserDto;
import com.myresume.api.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserMapper extends SuperMapper<User, CreateUserDto> {
    User toEntity(CreateUserDto dto);

    CreateUserDto toDto(User user);
}
