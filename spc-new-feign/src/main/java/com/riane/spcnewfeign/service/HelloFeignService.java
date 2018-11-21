package com.riane.spcnewfeign.service;

import com.riane.feignapi.service.FeignService;
import com.riane.spcnewfeign.fallback.FeignFallbanck;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "eureka-client", fallback = FeignFallbanck.class)
public interface HelloFeignService extends FeignService {
}
