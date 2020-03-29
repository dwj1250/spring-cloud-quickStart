package test.controller;

import org.springframework.web.client.RestTemplate;

public class utils {
    public static void main(String...args){
        RestTemplate restTemplate=new RestTemplate();
        String url="http://localhost:8083/actuator/refresh";
        restTemplate.postForLocation(url,null);
    }
}
