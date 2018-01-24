package com.neo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class HelloController {
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

//    @RequestMapping("user/{id}")
//    public SecurityProperties.User findById(@PathVariable Long id){
//        return this.restTemplate.getForObject("http://localhost:8000" + id, SecurityProperties.User.class);
//    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("spring-cloud-consumer");
    }
	
    @RequestMapping("/hello")
    public String index(@RequestParam String name) {
        return "hello "+name+"，this is first messge";
    }
}