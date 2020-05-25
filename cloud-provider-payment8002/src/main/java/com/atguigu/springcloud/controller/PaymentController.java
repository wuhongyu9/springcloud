package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/payment")
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping("/create")
    @ResponseBody
    public CommonResult<Payment> createPayment(@RequestBody Payment payment){
        int res = paymentService.createPayment(payment);
        log.info("插入数据库payment表,state:"+res);
        Payment cur_payment = paymentService.getPaymentBySerial(payment.getSerial());
        if(res > 0) {
            return new CommonResult<Payment>(200, "插入数据库成功,prot:"+port, cur_payment);
        }else{
            return new CommonResult<Payment>(444, "插入数据库失败,prot:"+port, null);
        }
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        log.info("查询数据库payment");
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult<Payment>(200, "查询数据库成功,prot:"+port, payment);
        }else{
            return new CommonResult<Payment>(444,"没有对应Id的Payment记录,id:"+id+",prot:"+port,null);
        }
    }
}
