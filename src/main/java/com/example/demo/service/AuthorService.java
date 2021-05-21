package com.example.demo.service;

import com.example.demo.service.mapping.AuthorConverter;
import com.example.demo.dto.AuthorDto;
import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.AuthorEntity;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AuthorConverter authorConverter;

    public AuthorDto save(AuthorDto authorDto) {
        AuthorEntity authorEntity = authorConverter.dtoToEntity(authorDto);
        AddressEntity addressEntity = addressRepository.save(authorEntity.getAddress());
        authorEntity.setAddress(addressEntity);
        authorEntity = authorRepository.save(authorEntity);
        return authorConverter.entityToDto(authorEntity);
    }

    public List<AuthorDto> getAll() {
        return authorConverter.entityToDto(authorRepository.findAll());
    }

}
