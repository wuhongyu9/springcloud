package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.ProductService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping("/reduceProductNum")
    public int reduceProductNum(Long productid,int pcount){
        return productService.reduceProductNum(productid,pcount);
    }
}
