package com.wqbr.clouddemo.helloserviceapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value="HELLO-SERVICE",fallbackFactory= HelloServiceFallbackFactory.class)
public interface HelloService {

    @GetMapping("/hello")
    public String hello();

}
