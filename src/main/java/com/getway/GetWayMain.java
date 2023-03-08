package com.getway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GetWayMain {
    public static void main(String[] args) {
        SpringApplication.run(GetWayMain.class,args);
    }
}
