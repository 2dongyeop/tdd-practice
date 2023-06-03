package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;

public interface PaymentPort {
    Order getOrder(final Long orderId);

    void save(final Payment payment);

    void pay(int price, String cardNumber);
}
