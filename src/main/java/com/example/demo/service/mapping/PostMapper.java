package com.example.demo.service.mapping;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.PostEntity;

import java.util.List;

public interface PostMapper extends DtoToEntityMapper<PostDto, PostEntity> {
    @Override
    PostEntity dtoToEntity(PostDto dto);
    @Override
    PostDto entityToDto(PostEntity entity);
    @Override
    List<PostEntity> dtoToEntity(List<PostDto> dtos);
    @Override
    List<PostDto> entityToDto(List<PostEntity> entities);
}
