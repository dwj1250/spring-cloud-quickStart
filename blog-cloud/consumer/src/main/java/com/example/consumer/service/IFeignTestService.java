package com.example.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("hello-first")
public interface IFeignTestService {
    @RequestMapping(value = "/provider/hello",method = RequestMethod.GET)
    String hello();

    @RequestMapping(value = "/provider/sayHello",method = RequestMethod.GET)
    String sayHelloToYou(@RequestParam(value = "name") String name);
}
