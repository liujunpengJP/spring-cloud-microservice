package com.itmuch.cloud.microservicezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class MicroserviceZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceZuulApplication.class, args);
    }

}
