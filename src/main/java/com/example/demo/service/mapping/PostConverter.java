package com.example.demo.service.mapping;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostConverter {

    @Autowired
    UserConverter userConverter;

    public PostDto entityToDto(PostEntity postEntity) {
        PostDto postDto = new PostDto();
        postDto.setId(postEntity.getId());
        postDto.setDescription(postEntity.getDescription());
        return postDto;
    }

    public List<PostDto> entityToDto(List<PostEntity> postEntityList) {
        return postEntityList.stream().map(post -> entityToDto(post)).collect(Collectors.toList());
    }

    public PostEntity dtoToEntity(PostDto postDto) {
        PostEntity postEntity = new PostEntity();
        postEntity.setId(postDto.getId());
        postEntity.setDescription(postDto.getDescription());
        postEntity.setUser(userConverter.dtoToEntity(postDto.getUserDto()));
        return postEntity;
    }

    public List<PostEntity> dtoToEntity(List<PostDto> postDtoList) {
        return postDtoList.stream().map(postDto -> dtoToEntity(postDto)).collect(Collectors.toList());
    }

}
