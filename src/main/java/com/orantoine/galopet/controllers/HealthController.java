package com.orantoine.galopet.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(path = "/ping")
    public String HealthCheck(){
        return "pong";
    }
}
