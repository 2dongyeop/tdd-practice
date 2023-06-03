package com.example.productorderservice.payment.application.port;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public interface PaymentPort {
    Order getOrder(final Long orderId);

    void save(final Payment payment);

    void pay(int price, String cardNumber);
}
