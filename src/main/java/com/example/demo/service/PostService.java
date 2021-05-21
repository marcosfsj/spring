package com.example.demo.service;

import com.example.demo.service.mapping.PostConverter;
import com.example.demo.dto.PostDto;
import com.example.demo.entity.PostEntity;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    PostConverter postConverter;

    public PostDto save(PostDto postDto) {
        PostEntity postEntity = postRepository.save(postConverter.dtoToEntity(postDto));
        return postConverter.entityToDto(postEntity);
    }

}
