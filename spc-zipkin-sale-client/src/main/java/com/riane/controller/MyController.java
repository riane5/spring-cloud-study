package com.riane.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/sale/{price}")
    public String saleBook(@PathVariable String price) {
        System.out.println("The book is $" + price);
        return "Sale Success";
    }
}
