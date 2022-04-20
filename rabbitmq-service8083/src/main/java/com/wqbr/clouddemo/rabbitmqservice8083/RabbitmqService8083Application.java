package com.wqbr.clouddemo.rabbitmqservice8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RabbitmqService8083Application {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqService8083Application.class, args);
    }

}
