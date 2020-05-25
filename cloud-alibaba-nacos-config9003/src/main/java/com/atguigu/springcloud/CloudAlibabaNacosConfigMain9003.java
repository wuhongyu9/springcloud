package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosConfigMain9003 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosConfigMain9003.class,args);
    }
}
