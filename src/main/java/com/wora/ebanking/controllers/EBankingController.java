package com.wora.ebanking.controllers;

import com.wora.ebanking.models.DTOs.CreateUserDto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.services.INTER.IUserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EBankingController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid CreateUserDto createUserDto) {
        UserDto savedUser = userService.save(createUserDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/notices")
    public String announce(){
        return "les annonces générales";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact us";
    }
}
