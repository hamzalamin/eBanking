package com.wora.ebanking.services.INTER;


import com.wora.ebanking.models.DTOs.CreateRoleDto;
import com.wora.ebanking.models.DTOs.RoleDto;
import com.wora.ebanking.models.entities.Role;

public interface IRoleService  {
    RoleDto save(CreateRoleDto createRoleDto);
    Role defaultRole();
}
