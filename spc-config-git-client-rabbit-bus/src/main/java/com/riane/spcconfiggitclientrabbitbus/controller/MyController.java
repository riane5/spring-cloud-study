package com.riane.spcconfiggitclientrabbitbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MyController {


    @Value("${name:unknow}")
    private String name;

    @GetMapping("/name")
    public String handleName() {
        return name;
    }

}
