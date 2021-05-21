package com.example.demo.service.mapping;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {

    @Autowired
    PostConverter postConverter;

    public UserDto entityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        userDto.setId(userEntity.getId());
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setPosts(postConverter.entityToDto(userEntity.getPosts()));
        return userDto;
    }

    public List<UserDto> entityToDto(List<UserEntity> userEntityList) {
        return userEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public UserEntity dtoToEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userDto.getId());
        userEntity.setFirstName(userDto.getFirstName());
        userEntity.setLastName(userDto.getLastName());
        return userEntity;
    }

    public List<UserEntity> dtoToEntity(List<UserDto> userDtoList) {
        return userDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
