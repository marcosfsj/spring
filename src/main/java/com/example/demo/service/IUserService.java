package com.example.demo.service;

import com.example.demo.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<UserDto> getUsers();
    public UserDto createNewUser(UserDto userDto);
    public Optional<UserDto> getUser(Long id);
    public void deleteUser(Long id);
}
