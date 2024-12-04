package com.wora.ebanking.models.DTOs;

import jakarta.validation.constraints.NotBlank;

public record ChangePasswordDto(
        @NotBlank String oldPassword,
        @NotBlank String newPassword
) {
}
