package com.myresume.api.user.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public interface SuperMapper<E, D> {
    D toDto(E entity);

    E toEntity(D dto);

    default List<D> toDto(Collection<E> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<E> toEntity(List<D> fieldDtos) {
        return fieldDtos.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
