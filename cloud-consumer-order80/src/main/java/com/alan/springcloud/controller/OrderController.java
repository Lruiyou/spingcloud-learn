package com.alan.springcloud.controller;

import com.alan.springcloud.common.CommonResult;
import com.alan.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

    //服务地址不能写死
//    private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    /*
    *  访问使用get请求，实际服务里面调的是post
    */
    @GetMapping(value = "/consumer/payment")
    public CommonResult<Payment> create(Payment payment){
        return  restTemplate.postForObject(PAYMENT_URL + "/payment",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }
}
