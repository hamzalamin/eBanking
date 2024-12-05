package com.wora.ebanking.controllers;


import com.wora.ebanking.models.DTOs.CreateRoleDto;
import com.wora.ebanking.models.DTOs.RoleDto;
import com.wora.ebanking.models.DTOs.UserDto;
import com.wora.ebanking.services.INTER.IRoleService;
import com.wora.ebanking.services.INTER.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final IUserService userService;
    private final IRoleService roleService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> findAllUsers(
            @RequestParam Integer pageNumber,
            @RequestParam Integer size) {
        List<UserDto> users = userService.findAll(pageNumber, size);
        return new ResponseEntity<>(users, HttpStatus.OK);
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

    @PostMapping("/role/create")
    public ResponseEntity<RoleDto> createRole(@RequestBody CreateRoleDto createRoleDto) {
        RoleDto roleDto = roleService.save(createRoleDto);
        return new ResponseEntity<>(roleDto, HttpStatus.CREATED);
    }
}
