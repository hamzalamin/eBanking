package com.wora.ebanking.mappers;

import com.wora.ebanking.mappers.API.GenericMapper;
import com.wora.ebanking.models.DTOs.CreateRoleDto;
import com.wora.ebanking.models.DTOs.RoleDto;
import com.wora.ebanking.models.entities.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends GenericMapper<Role, RoleDto> {
    Role toEntity(RoleDto roleDto);
    Role toEntity(CreateRoleDto createRoleDto);
    RoleDto toDto(Role role);

}
