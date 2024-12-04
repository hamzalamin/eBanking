package com.wora.ebanking.models.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String email,
        @NotNull RoleDto role
) {
}
