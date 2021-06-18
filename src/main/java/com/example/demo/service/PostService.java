package com.example.demo.service;

import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.mapping.DtoToEntityMapper;
import com.example.demo.service.mapping.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    PostRepository postRepository;
    DtoToEntityMapper<PostDto, PostEntity> postMapper;

    @Autowired
    public PostService(PostRepository postRepository, DtoToEntityMapper<PostDto, PostEntity> postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostDto save(PostDto postDto) {
//        Optional<UserDto> userDtoOptional = userService.getUser(postDto);
//        if(!userDtoOptional.isPresent()) {
//            throw new NotFoundException("id: " + userId);
//        }
        PostEntity postEntity = postRepository.save(postMapper.dtoToEntity(postDto));
        return postMapper.entityToDto(postEntity);
    }

}
