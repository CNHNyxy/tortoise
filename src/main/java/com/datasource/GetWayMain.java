package com.datasource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.datasource.mapper")
@EnableFeignClients
public class GetWayMain {
    public static void main(String[] args) {
        SpringApplication.run(GetWayMain.class,args);
    }
}
