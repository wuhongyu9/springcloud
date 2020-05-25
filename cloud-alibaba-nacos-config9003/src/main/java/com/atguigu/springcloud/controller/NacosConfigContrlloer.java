package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosConfigContrlloer {
    @Value("${config.info}")
    public String info;

    @RequestMapping("/config/info")
    public String getConfigInfo(){
        return info;
    }
}
