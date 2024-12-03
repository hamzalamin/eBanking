package com.wora.ebanking.services.INTER;

import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UpdateUserDtto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.services.GenericService;

public interface IUserService extends GenericService<CreateUserDto, UpdateUserDtto, UserDto, Long> {
}
