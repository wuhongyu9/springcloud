package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.TOrder;

public interface OrderService {
    public void create(TOrder tOrder);

    public int update(Long id,int status);
}
