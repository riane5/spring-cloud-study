package com.riane.spcnewfeign.fallback;

import com.riane.spcnewfeign.service.HelloFeignService;
import org.springframework.stereotype.Component;

@Component
public class FeignFallbanck implements HelloFeignService {

    @Override
    public String hello(String s) {
        return "Hello error";
    }

    @Override
    public String hello2() {
        return "Hello2 error";
    }
}
