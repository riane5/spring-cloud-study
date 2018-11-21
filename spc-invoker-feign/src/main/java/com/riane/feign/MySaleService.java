package com.riane.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "zipkin-sale-feign")
public interface MySaleService {

    @GetMapping("/sale/{price}")
    String saleBook(@PathVariable("price") String price);
}
