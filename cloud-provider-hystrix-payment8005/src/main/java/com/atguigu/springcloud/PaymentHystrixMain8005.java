package com.atguigu.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentHystrixMain8005 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentHystrixMain8005.class,args);
    }

    public class ServletConfigBean {
        @Bean
        public ServletRegistrationBean hystrixMetricsStreamServlet() {
            ServletRegistrationBean regist = new ServletRegistrationBean();
            regist.setServlet(new HystrixMetricsStreamServlet());
            regist.setName("hystrixMetricsStreamServlet");
            regist.setLoadOnStartup(1);
            regist.addUrlMappings("/hystrix.stream");
            return regist;
        }
    }
}
