package com.wora.ebanking.controllers;

import com.wora.ebanking.models.DTOs.ChangePasswordDto;
import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UpdateUserDto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.services.INTER.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        UserDto savedUser = userService.save(createUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UpdateUserDto updateUserDto, @PathVariable Long id) {
        UserDto updatedUser = userService.update(updateUserDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAllUsers(
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer size) {
        List<UserDto> users = userService.findAll(pageNumber, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>("USER WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<String> changePassword(
            @RequestBody @Valid ChangePasswordDto changePasswordDto,
            @PathVariable Long id) {
        userService.changePassword(changePasswordDto, id);
        return new ResponseEntity<>("Password changed successfully!", HttpStatus.OK);
    }

}
