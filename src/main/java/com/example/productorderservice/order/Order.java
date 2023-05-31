package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.util.Assert;

public class Order {

    private Long id;
    private final Product product;
    private final int quantity;

    public Order(final Product product, final int quantity) {
        Assert.notNull(product);
        Assert.isTrue(quantity > 0);
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
