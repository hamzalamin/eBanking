package com.wora.ebanking.services.IMPL;

import com.wora.ebanking.exceptions.EntityNotFoundException;
import com.wora.ebanking.exceptions.PasswordIncorrect;
import com.wora.ebanking.mappers.UserMapper;
import com.wora.ebanking.models.DTOs.ChangePasswordDto;
import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UpdateUserDto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.models.entities.Role;
import com.wora.ebanking.models.entities.User;
import com.wora.ebanking.repositoies.UserRepository;
import com.wora.ebanking.services.INTER.IRoleService;
import com.wora.ebanking.services.INTER.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final IRoleService roleService;

    @Override
    public UserDto save(CreateUserDto createUserDto) {
        User user = userMapper.toEntity(createUserDto);
        String encodedPassword = passwordEncoder.encode(createUserDto.password());
        user.setPassword(encodedPassword);
        Role role = roleService.defaultRole();
        user.setRole(role);
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
        return userMapper.toDto(user);
    }

    @Override
    public UserDto update(UpdateUserDto updateUserDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
        user.setName(updateUserDto.name())
                .setEmail(updateUserDto.email());
        return userMapper.toDto(user);
    }

    @Override
    public List<UserDto> findAll(Integer pageNumber, Integer size) {
        return List.of();
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
        userRepository.delete(user);
    }

    @Override
    public void changePassword(ChangePasswordDto changePasswordDto, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User", id));
        if (!passwordEncoder.matches(changePasswordDto.oldPassword(), user.getPassword())) {
            throw new PasswordIncorrect("Old password is incorrect.");
        }
        String encodedNewPassword = passwordEncoder.encode(changePasswordDto.newPassword());
        user.setPassword(encodedNewPassword);
        userRepository.save(user);
    }
}
