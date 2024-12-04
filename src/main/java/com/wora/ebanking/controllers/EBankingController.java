package com.wora.ebanking.controllers;

import com.wora.ebanking.models.DTOs.CreateRoleDto;
import com.wora.ebanking.models.DTOs.RoleDto;
import com.wora.ebanking.services.INTER.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EBankingController {

    private final IRoleService roleService;

    @GetMapping("/notices")
    public String announce(){
        return "les annonces générales";
    }

    @PostMapping("/role/create")
    public ResponseEntity<RoleDto> createRole(@RequestBody CreateRoleDto createRoleDto) {
        RoleDto roleDto = roleService.save(createRoleDto);
        return new ResponseEntity<>(roleDto, HttpStatus.CREATED);
    }

    @GetMapping("/card")
    public String card(){
        return "your Card";
    }

    @GetMapping("/users")
    public String users(){
        return "List of users";
    }

    @GetMapping("/admin")
    public String admin(){
        return "im admin";
    }
}
