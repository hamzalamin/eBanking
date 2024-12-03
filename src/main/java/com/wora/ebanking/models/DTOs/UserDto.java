package com.wora.ebanking.models.DTOs;

public record UserDto(
        Long id,
        String name,
        String email,
        RoleDto role
) {
}
