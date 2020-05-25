package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.TOrder;
import com.atguigu.springcloud.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
@Slf4j

public class OrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping("/create")
    public void create(){
        TOrder order = new TOrder();
        order.setProductid(1L);
        order.setPcount(1);
        order.setMoney(100f);
        order.setStatus(0);
        order.setUserid(1L);
        orderService.create(order);
    }

    @RequestMapping("/update/{id}/{status}")
    public int update(@PathVariable("id") Long id,@PathVariable("status") int status){
        log.info("----------更新Order状态");
        return  orderService.update(id,status);
    }
}
