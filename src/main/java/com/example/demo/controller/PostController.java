package com.example.demo.controller;

import com.example.demo.dto.PostDto;
import com.example.demo.dto.UserDto;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.IPostService;
import com.example.demo.service.IUserService;
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

    @Autowired
    IUserService userService;
    @Autowired
    IPostService postService;

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
        Optional<UserDto> userDtoOptional = userService.getUser(userId);
        if(!userDtoOptional.isPresent()) {
            throw new NotFoundException("id: " + userId);
        }
        UserDto userDto = userDtoOptional.get();
        postDto.setUserDto(userDto);
        postService.save(postDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{Id}").buildAndExpand(postDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

}