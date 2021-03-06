package com.example.demo.service.mapping;

import java.util.List;

public interface DtoToEntityMapper<DtoT, EntityT> {
    EntityT dtoToEntity(DtoT dto);
    DtoT entityToDto(EntityT entity);
    List<EntityT> dtoToEntity(List<DtoT> dtos);
    List<DtoT> entityToDto(List<EntityT> entities);
}


