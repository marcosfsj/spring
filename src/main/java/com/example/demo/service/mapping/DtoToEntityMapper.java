package com.example.demo.service.mapping;

public interface DtoToEntityMapper<Dto, Entity> {
    Entity dtoToEntity(Dto dto);
    Dto entityToDto(Entity entity);
}


