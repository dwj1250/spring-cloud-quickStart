package test.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RefreshScope
public class TestController {

    @Autowired
    private DiscoveryClient client;

    @Value("${name}")
    private String name;


    private static final String HELLO_SERVICE="/provider/hello";

    @GetMapping("/provider2/hello")
    @HystrixCommand
    public String test(){
        RestTemplate restTemplate=new RestTemplate();
        List<String> list= client.getServices();
        list.forEach(item->System.out.println(item));
        List<ServiceInstance> instances=client.getInstances("hello-first");
        ServiceInstance serviceInstance= instances.get(0);
        return restTemplate.getForObject(serviceInstance.getUri()+HELLO_SERVICE,String.class);
    }

    @GetMapping("/provider2/getServices")
    public String test2(){
        List<String> list= client.getServices();
        return list.toString();
    }

    @GetMapping("/provider2/getMyName")
    public String getMyName(){
        return name;
    }


}
