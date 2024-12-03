package com.wora.ebanking.mappers;

import com.wora.ebanking.mappers.API.GenericMapper;
import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UpdateUserDtto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.models.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends GenericMapper<User, UserDto> {
    User toEntity(UserDto userDto);
    User toEntity(CreateUserDto createUserDto);
    User toEntity(UpdateUserDtto updateUserDtto);
    UserDto toDto(User user);

}
