package com.example.demo.service.mapping;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(
        builder = @Builder(disableBuilder = true),
        uses = {PostMapper.class}
)
public interface UserMapper extends DtoToEntityMapper<UserDto, UserEntity> {

    @Override
    UserEntity dtoToEntity(UserDto dto);

    @Override
    UserDto entityToDto(UserEntity entity);

}
