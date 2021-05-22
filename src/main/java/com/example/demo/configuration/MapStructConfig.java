package com.example.demo.configuration;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.AddressEntity;
import com.example.demo.service.mapping.AddressMapper;
import com.example.demo.service.mapping.DtoToEntityMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapStructConfig {

    @Bean
    public DtoToEntityMapper<AddressDto, AddressEntity> addressMapper() {
        return Mappers.getMapper(AddressMapper.class);
    }

}