package com.wora.ebanking.models.DTOs;

import jakarta.validation.constraints.NotBlank;

public record CreateUserDto(
        @NotBlank String name,
        @NotBlank String email,
        @NotBlank String password
) {
}
