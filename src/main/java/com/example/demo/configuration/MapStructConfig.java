package com.example.demo.configuration;

import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.mapping.DtoToEntityMapper;
import com.example.demo.service.mapping.PostMapper;
import com.example.demo.service.mapping.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    @Bean
    public DtoToEntityMapper<UserDto, UserEntity> userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }

    @Bean
    public DtoToEntityMapper<PostDto, PostEntity> postMapper() {
        return Mappers.getMapper(PostMapper.class);
    }

}