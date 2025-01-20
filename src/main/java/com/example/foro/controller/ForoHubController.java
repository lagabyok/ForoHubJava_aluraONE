package com.example.foro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ForoHubController {

    @GetMapping("/")
    public String home() {
        return "Bienvenido al ForoHub";
    }

    @GetMapping("/foro")
    public String foro() {
        return "Página del Foro";
    }
}
