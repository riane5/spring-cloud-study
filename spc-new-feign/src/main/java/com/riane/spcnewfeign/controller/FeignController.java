package com.riane.spcnewfeign.controller;

import com.riane.feignapi.service.FeignService;
import com.riane.spcnewfeign.service.HelloFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController implements FeignService {

    @Autowired
    private HelloFeignService feignService;


    @Override
    public String hello(@PathVariable("name") String s) {
        return feignService.hello(s);
    }

    @Override
    public String hello2() {
        return feignService.hello2();
    }
}
