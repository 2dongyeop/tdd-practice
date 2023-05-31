package com.example.productorderservice.order;

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
