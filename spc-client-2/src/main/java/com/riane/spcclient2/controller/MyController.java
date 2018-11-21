package com.riane.spcclient2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @RequestMapping("/eclient/{name}")
    public String hello(@PathVariable("name") String name) {
        return "hello" + name + ",2";
    }

    @RequestMapping("/hello")
    public String hello2() {
        return "hello this is client 2";
    }
}
