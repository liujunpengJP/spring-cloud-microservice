package com.itmuch.cloud.microserviceprovideruser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.itmuch.cloud.microserviceprovideruser.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class MicroserviceProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceProviderUserApplication.class, args);
    }

}
