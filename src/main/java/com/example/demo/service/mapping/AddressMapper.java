package com.example.demo.service.mapping;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.AddressEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public interface AddressMapper extends DtoToEntityMapper<AddressDto, AddressEntity> {
    AddressEntity dtoToEntity(AddressDto addressDto);
    @InheritInverseConfiguration
    AddressDto entityToDto(AddressEntity addressEntity);
}

