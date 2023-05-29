package com.example.productorderservice.product;

import org.springframework.util.Assert;

public record UpdateProductRequest(
        String name,
        int price,
        DiscountPolicy discountPolicy
) {

    public UpdateProductRequest {
        Assert.hasText(name, "필수");
        Assert.isTrue(price > 0, "필수");
        Assert.notNull(discountPolicy, "필수");
    }
}
