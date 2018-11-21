package com.riane.spcfeignapi.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public interface MyFeignService {

    @RequestMapping("/eclient/{name}")
    String hello(@PathVariable("name") String name);

    @RequestMapping("/hello")
    String hello2();

}
