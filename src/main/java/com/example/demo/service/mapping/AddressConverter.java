package com.example.demo.service.mapping;

import com.example.demo.dto.AddressDto;
import com.example.demo.entity.AddressEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AddressConverter {

    public AddressDto entityToDto(AddressEntity addressEntity) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(addressEntity.getId());
        addressDto.setCity(addressEntity.getCity());
        return addressDto;
    }

    public List<AddressDto> entityToDto(List<AddressEntity> addressEntityList) {
        return addressEntityList.stream().map(this::entityToDto).collect(Collectors.toList());
    }

    public AddressEntity dtoToEntity(AddressDto addressDto) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressDto.getId());
        addressEntity.setCity(addressDto.getCity());
        return addressEntity;
    }

    public List<AddressEntity> dtoToEntity(List<AddressDto> addressDtoList) {
        return addressDtoList.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

}
