package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosProviderPaymentMain9002 {
    public static void main(String[] args) {
        //-DServer.port=9011
        SpringApplication.run(CloudAlibabaNacosProviderPaymentMain9002.class,args);
    }
}
