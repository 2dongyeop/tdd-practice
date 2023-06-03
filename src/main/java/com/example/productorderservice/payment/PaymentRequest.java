package com.example.productorderservice.payment;

import org.springframework.util.Assert;

public record PaymentRequest(Long orderId, String cardNumber) {
    public PaymentRequest {
        Assert.notNull(orderId);
        Assert.hasText(cardNumber);
    }
}
