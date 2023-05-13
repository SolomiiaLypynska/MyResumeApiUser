package com.myresume.api.user.mapper;

import com.myresume.api.user.dto.CreateUserRequestDto;
import com.myresume.api.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateUserRequestMapper extends SuperMapper<User, CreateUserRequestDto> {
    User toEntity(CreateUserRequestDto dto);

    CreateUserRequestDto toDto(User user);
}
