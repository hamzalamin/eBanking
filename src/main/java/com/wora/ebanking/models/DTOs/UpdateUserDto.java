package com.wora.ebanking.models.DTOs;

import jakarta.validation.constraints.NotBlank;

public record UpdateUserDto(
        @NotBlank String name,
        @NotBlank String email
) {
}
