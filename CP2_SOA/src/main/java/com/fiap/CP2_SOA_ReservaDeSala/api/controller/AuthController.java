package com.fiap.CP2_SOA_ReservaDeSala.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login() {
        return "TOKEN_FAKE";
    }
}