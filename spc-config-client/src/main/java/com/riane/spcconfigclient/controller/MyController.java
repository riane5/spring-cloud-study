package com.riane.spcconfigclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private Environment environment;

    @RequestMapping("/name")
    public String getName() {
        String property = environment.getProperty("my.name", "未知");
        return property;
    }

    @RequestMapping("/info")
    public String getInfo() {
        String property = environment.getProperty("my.info", "INfo未知");
        return property;
    }

    @RequestMapping("/port")
    public String getPort() {
        String port = System.getProperty("server.port", "8888");
        return port;
    }

}
