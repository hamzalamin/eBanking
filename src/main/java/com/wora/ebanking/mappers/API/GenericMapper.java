package com.wora.ebanking.mappers.API;

public interface GenericMapper<ENTITY, DTO> {
    ENTITY toEntity(ENTITY entity);
    DTO toDto(DTO dto);
}