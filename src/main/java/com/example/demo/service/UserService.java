package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.mapping.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    UserRepository userRepository;
    UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
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

    public Optional<UserDto> getUser(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isPresent()) {
            return Optional.of(userMapper.entityToDto(userEntityOptional.get()));
        }
        return Optional.of(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
