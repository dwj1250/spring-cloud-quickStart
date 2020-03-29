package provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private DiscoveryClient client;

    @GetMapping("/provider/hello")
    public String hello(){
        return "Hello ,I am provider1_copy";
    }

    @GetMapping("/provider/sayHello")
    public String sayHello(@RequestParam(value = "name") String name){
        return "hello "+name+" I am provider1_copy";
    }

}
