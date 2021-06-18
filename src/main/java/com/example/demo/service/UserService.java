package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.mapping.DtoToEntityMapper;
import com.example.demo.service.mapping.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService {

    UserRepository userRepository;
    DtoToEntityMapper<UserDto, UserEntity> userMapper;

    @Autowired
    public UserService(UserRepository userRepository, DtoToEntityMapper<UserDto, UserEntity> userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserDto> getUsers() {
        return userMapper.entityToDto(userRepository.findAll());
    }

    public UserDto createNewUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(userMapper.dtoToEntity(userDto));
        return userMapper.entityToDto(userEntity);
    }

    public UserDto getUser(Long id) {
        return userRepository.findById(id).map(userEntity -> userMapper.entityToDto(userEntity)).orElse(null);

    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
