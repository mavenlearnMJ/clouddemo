package com.wqbr.clouddemo.helloservice8082.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hello")
    public String Hello(){
        List<String> list = discoveryClient.getServices();
        for(String str : list){
            List<ServiceInstance> l = discoveryClient.getInstances(str);
            for(ServiceInstance a : l){
                System.out.println(a.getHost()+"---"+a.getInstanceId());
            }
        }
        return "hello";
    }

}
