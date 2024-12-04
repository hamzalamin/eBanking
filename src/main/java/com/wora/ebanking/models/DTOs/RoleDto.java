package com.wora.ebanking.models.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record RoleDto(
        @Positive @NotNull Long id,
        @NotBlank String name
) {
}
