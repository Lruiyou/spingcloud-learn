package com.alan.springcloud.controller;

import com.alan.springcloud.common.CommonResult;
import com.alan.springcloud.entity.Payment;
import com.alan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("*********插入结果:" + result);
        if (result > 0){
            return new CommonResult(200,"新增成功，serverPort："+serverPort,result);
        }else {
            return new CommonResult(500,"新增失败，serverPort："+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment result = paymentService.getPaymentById(id);
        log.info("*********查询结果:" + result);
        if (result != null){
            return new CommonResult(200,"查询成功，serverPort："+serverPort,result);
        }else {
            return new CommonResult(500,"没有对应记录，查询ID："+id,null);
        }
    }
}
