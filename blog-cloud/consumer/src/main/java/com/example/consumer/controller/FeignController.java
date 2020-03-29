package com.example.consumer.controller;

import com.example.consumer.service.IFeignTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private IFeignTestService service;

    @GetMapping("/feign/hello")
    public String test(){
        return service.hello();
    }

    @GetMapping("/feign/sayHello/{name}")
    public String sayHello(@PathVariable(value = "name") String name){
        return service.sayHelloToYou(name);
    }

}
