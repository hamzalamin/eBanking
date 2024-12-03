package com.wora.ebanking.models.DTOs;

public record CreateUserDto(
        String name,
        String email,
        RoleDto roleId
) {
}
