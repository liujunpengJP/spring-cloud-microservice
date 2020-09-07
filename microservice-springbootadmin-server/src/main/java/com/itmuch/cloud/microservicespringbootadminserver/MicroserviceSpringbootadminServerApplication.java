package com.itmuch.cloud.microservicespringbootadminserver;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@EnableAdminServer
@EnableEurekaClient
public class MicroserviceSpringbootadminServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceSpringbootadminServerApplication.class, args);
    }

}
