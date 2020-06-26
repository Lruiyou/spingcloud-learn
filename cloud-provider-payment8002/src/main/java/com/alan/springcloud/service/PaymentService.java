package com.alan.springcloud.service;

import com.alan.springcloud.entity.Payment;

public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(Long id);
}
