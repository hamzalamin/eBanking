package com.wora.ebanking.services.INTER;

import com.wora.ebanking.models.DTOs.ChangePasswordDto;
import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UpdateUserDto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.services.GenericService;

public interface IUserService extends GenericService<CreateUserDto, UpdateUserDto, UserDto, Long> {
    void changePassword(ChangePasswordDto changePasswordDto, String name);
}
