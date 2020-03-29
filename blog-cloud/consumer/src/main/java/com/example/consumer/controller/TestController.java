package com.example.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {

    private static final String ipAddr="http://192.168.56.1";
    private static final String providerPort=":8081";

    @GetMapping("/hello")
    public String hello(){
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(ipAddr+providerPort+"/provider/hello",String.class);
    }


}
