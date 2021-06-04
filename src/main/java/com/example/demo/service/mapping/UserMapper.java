package com.example.demo.service.mapping;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;

public interface UserMapper extends DtoToEntityMapper<UserDto, UserEntity> {

    @Override
    UserEntity dtoToEntity(UserDto dto);

    @Override
    UserDto entityToDto(UserEntity entity);
}
