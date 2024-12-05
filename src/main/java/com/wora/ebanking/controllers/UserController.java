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

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UpdateUserDto updateUserDto, @PathVariable Long id) {
        UserDto updatedUser = userService.update(updateUserDto, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }


    @PutMapping("/{id}/change-password")
    public ResponseEntity<String> changePassword(
            @RequestBody @Valid ChangePasswordDto changePasswordDto,
            @PathVariable Long id) {
        userService.changePassword(changePasswordDto, id);
        return new ResponseEntity<>("Password changed successfully!", HttpStatus.OK);
    }


    @GetMapping("/myLoans")
    public String myLoans(){
        return "my Loans";
    }

    @GetMapping("/myCards")
    public String myCards(){
        return "my Cards";
    }

    @GetMapping("/myAccount")
    public String myAccount(){
        return "my Account";
    }

    @GetMapping("/myBalance")
    public String myBalance(){
        return "my Balance";
    }

}
