package com.example.demo.service;

import com.example.demo.dto.PostDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import com.example.demo.service.mapping.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    PostRepository postRepository;
    PostMapper postMapper;

    @Autowired
    public PostService(PostRepository postRepository, PostMapper postMapper) {
        this.postRepository = postRepository;
        this.postMapper = postMapper;
    }

    public PostDto save(PostDto postDto) {
        PostEntity postEntity = postRepository.save(postMapper.dtoToEntity(postDto));
        return postMapper.entityToDto(postEntity);
    }

}
