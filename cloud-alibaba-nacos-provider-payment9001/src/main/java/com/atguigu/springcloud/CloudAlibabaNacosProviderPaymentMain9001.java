package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosProviderPaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosProviderPaymentMain9001.class,args);
    }
}
