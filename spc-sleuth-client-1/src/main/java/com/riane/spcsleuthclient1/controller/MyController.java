package com.riane.spcsleuthclient1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyController {


    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/test1")
    public String test1() {
        String object = restTemplate.getForObject("http://sleuth-client-1-1/test1", String.class);
        return object;
    }
}
