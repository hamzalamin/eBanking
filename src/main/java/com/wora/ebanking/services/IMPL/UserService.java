package com.wora.ebanking.services.IMPL;

import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UpdateUserDtto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.repositoies.UserRepository;
import com.wora.ebanking.services.INTER.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        return null;
    }

    @Override
    public UserDto findById(Long aLong) {
        return null;
    }

    @Override
    public UserDto update(UpdateUserDtto updateUserDtto, Long aLong) {
        return null;
    }

    @Override
    public List<UserDto> findAll(Integer pageNumber, Integer size) {
        return List.of();
    }

    @Override
    public void delete(Long aLong) {

    }
}
