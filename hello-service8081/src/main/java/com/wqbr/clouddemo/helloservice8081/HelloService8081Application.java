package com.wqbr.clouddemo.helloservice8081;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class HelloService8081Application {

    public static void main(String[] args) {
        SpringApplication.run(HelloService8081Application.class, args);
    }

}
