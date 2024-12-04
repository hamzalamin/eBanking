package com.wora.ebanking.services.IMPL;

import com.wora.ebanking.exceptions.EntityNotFoundException;
import com.wora.ebanking.mappers.RoleMapper;
import com.wora.ebanking.models.DTOs.CreateRoleDto;
import com.wora.ebanking.models.DTOs.RoleDto;
import com.wora.ebanking.models.entities.Role;
import com.wora.ebanking.repositoies.RoleRepository;
import com.wora.ebanking.services.INTER.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService implements IRoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto save(CreateRoleDto createRoleDto) {
        Role role = roleMapper.toEntity(createRoleDto);
        Role savedRole = roleRepository.save(role);
        return roleMapper.toDto(savedRole);
    }

    @Override
    public Role defaultRole(){
        return roleRepository.findByName("ROLE_USER")
                .orElseThrow(() -> new EntityNotFoundException("Role", "ROLE_USER"));
    }
}
