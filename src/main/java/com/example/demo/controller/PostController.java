package com.example.demo.controller;

import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class PostController {

    UserService userService;
    PostService postService;

    @Autowired
    public PostController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping("/users/{userId}/posts")
    public List<PostDto> list(@PathVariable Long userId) {
        UserDto userDto = userService.search(userId);
        if(userDto == null) {
            throw new NotFoundException("id: " + userId);
        }
        return userDto.getPosts();
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> create(@PathVariable Long userId, @Valid @RequestBody PostDto postDto) {
        postService.save(postDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(postDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}