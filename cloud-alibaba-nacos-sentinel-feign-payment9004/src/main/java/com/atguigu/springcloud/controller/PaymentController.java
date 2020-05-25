package com.atguigu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.fallbacks.MyBacks;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    //直接/关联
    @RequestMapping("/testA")
    public String testA(){
        return "testA";
    }
    @RequestMapping("/testB")
    public String testB(){
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("------testB");
        return "testB";
    }

    @RequestMapping("/testC")
    @SentinelResource(value = "testC",fallback = "testCFallBack")
    public String testC(){
        int age = 10 / 0;
        return "testC";
    }

    public String testCFallBack(){
        return "testC Handler";
    }

    @RequestMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "testHotKeyHandler")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "test hot key";
    }

    public String testHotKeyHandler(String p1, String p2, BlockException e){
        return "test hot key blockHandler";
    }

    public String testHotKeyFallBack(String p1, String p2, BlockException e){
        return "fallback";
    }
}
