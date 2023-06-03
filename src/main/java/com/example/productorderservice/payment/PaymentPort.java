package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.stereotype.Component;

@Component
public interface PaymentPort {
    Order getOrder(final Long orderId);

    void save(final Payment payment);

    void pay(int price, String cardNumber);
}
