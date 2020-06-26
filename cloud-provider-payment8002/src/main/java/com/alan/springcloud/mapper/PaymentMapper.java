package com.alan.springcloud.mapper;

import com.alan.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
