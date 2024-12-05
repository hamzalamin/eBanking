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

import java.security.Principal;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUserById(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>("USER WITH ID: " + id + " DELETED SUCCESSFULLY !!", HttpStatus.OK);
    }

    @PutMapping("/change-password/{name}")
    public ResponseEntity<String> changePassword(@PathVariable String name,
                                                 @RequestBody @Valid ChangePasswordDto changePasswordDto
    ) {

//        String authUserName = principal.getName();
//        System.out.println("Authenticated username: " + authUserName);
//
//        if (!authUserName.equals(name)){
//            throw new RuntimeException("hsahzszasza");
//        }

        userService.changePassword(changePasswordDto, name);
        return new ResponseEntity<>("USER changed SUCCESSFULLY !!", HttpStatus.OK);
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
