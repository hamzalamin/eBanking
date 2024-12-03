package com.wora.ebanking.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EBankingController {

    @GetMapping("/notices")
    public String announce(){
        return "les annonces générales";
    }

    @GetMapping("/card")
    public String card(){
        return "your Card";
    }

    @GetMapping("/users")
    public String users(){
        return "List of users";
    }
}
