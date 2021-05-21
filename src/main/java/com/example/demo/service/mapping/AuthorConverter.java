package com.example.demo.service.mapping;

import com.example.demo.dto.AuthorDto;
import com.example.demo.entity.AuthorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AuthorConverter {

    @Autowired
    AddressConverter addressConverter;

    public AuthorDto entityToDto(AuthorEntity authorEntity) {
        AuthorDto authorDto = new AuthorDto();
        authorDto.setId(authorEntity.getId());
        authorDto.setName(authorEntity.getName());
        authorDto.setAddress(addressConverter.entityToDto(authorEntity.getAddress()));
        return authorDto;
    }

    public List<AuthorDto> entityToDto(List<AuthorEntity> authorEntityList) {
        return authorEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public AuthorEntity dtoToEntity(AuthorDto authorDto) {
        AuthorEntity authorEntity = new AuthorEntity();
        authorEntity.setId(authorDto.getId());
        authorEntity.setName(authorDto.getName());
        authorEntity.setAddress(addressConverter.dtoToEntity(authorDto.getAddress()));
        return authorEntity;
    }

    public List<AuthorEntity> dtoToEntity(List<AuthorDto> authorDtoList) {
        return authorDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
