package com.wora.ebanking.models.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CreateRoleDto(
        @NotBlank String name
) {
}
