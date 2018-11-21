package com.riane.spceurekacaller.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String PROVIDERNAME = "http://eureka-client/";

    @RequestMapping("/eclient/{name}")
    public String hello(@PathVariable("name") String name) {
       return restTemplate.getForObject(PROVIDERNAME + "eclient/" + name, String.class);
    }
}
