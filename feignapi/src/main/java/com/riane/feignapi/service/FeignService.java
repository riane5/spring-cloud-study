package com.riane.feignapi.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface FeignService {

    @RequestMapping("/eclient/{name}")
    String hello(@PathVariable("name") String name);

    @RequestMapping("/hello")
    String hello2();
}
