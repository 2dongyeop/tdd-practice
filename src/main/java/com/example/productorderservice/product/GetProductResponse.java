package com.example.productorderservice.product;

import org.springframework.util.Assert;

record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    GetProductResponse {
        Assert.notNull(id, "필수입니다.");
        Assert.hasText(name, "필수입니다.");
        Assert.notNull(discountPolicy, "필수입니다.");
    }
}
