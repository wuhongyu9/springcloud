package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServerMain9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServerMain9002.class,args);
    }
}
