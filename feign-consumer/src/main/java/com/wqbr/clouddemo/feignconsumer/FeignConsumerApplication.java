package com.wqbr.clouddemo.feignconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = {"com.wqbr.clouddemo.helloserviceapi.service"})
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.wqbr.clouddemo")
public class FeignConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignConsumerApplication.class, args);
    }

}
