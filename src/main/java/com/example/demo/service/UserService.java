package com.example.demo.service;

import com.example.demo.service.mapping.UserConverter;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserConverter userConverter;

    public List<UserDto> getUsers() {
        return userConverter.entityToDto(userRepository.findAll());
    }

    public UserDto createNewUser(UserDto userDto) {
        UserEntity userEntity = userRepository.save(userConverter.dtoToEntity(userDto));
        return userConverter.entityToDto(userEntity);
    }

    public Optional<UserDto> getUser(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if(userEntityOptional.isPresent()) {
            return Optional.of(userConverter.entityToDto(userEntityOptional.get()));
        }
        return Optional.of(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
