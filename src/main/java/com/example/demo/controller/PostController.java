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
import java.util.Optional;

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
    public List<PostDto> getPosts(@PathVariable Long userId) {
        Optional<UserDto> userDtoOptional = userService.getUser(userId);
        if(!userDtoOptional.isPresent()) {
            throw new NotFoundException("id: " + userId);
        }
        return userDtoOptional.get().getPosts();
    }

    @PostMapping("/users/{userId}/posts")
    public ResponseEntity<Object> createNewPost(@PathVariable Long userId, @Valid @RequestBody PostDto postDto) {
        postService.save(postDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(postDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}