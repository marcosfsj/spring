package com.example.demo.controller;

import com.example.demo.exception.NotFoundException;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import com.example.demo.dto.UserDto;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/users/{id}")
    public EntityModel<UserDto> getUser(@PathVariable Long id) {
        UserDto userDto = userService.getUser(id).orElse(null);
        if(userDto == null) {
            throw new NotFoundException("id: " + id);
        }
        EntityModel<UserDto> resource = EntityModel.of(userDto);
        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).getUsers());
        resource.add(linkTo.withRel("get-users"));
        return resource;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createNewUser(@Valid @RequestBody UserDto userDto) {
        userDto = userService.createNewUser(userDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDto.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}