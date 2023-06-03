package com.example.productorderservice.order.application.service;

import org.springframework.util.Assert;

public record CreateOrderRequest(
        Long productId,
        int quantity
) {


    public CreateOrderRequest {
        Assert.notNull(productId);
        Assert.isTrue(quantity > 0);
    }
}
