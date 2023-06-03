package com.example.productorderservice.payment;

import com.example.productorderservice.order.Order;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {

    private final PaymentPort paymentPort;

    public PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(final PaymentRequest request) {

        final Order order = paymentPort.getOrder(request.orderId());

        final Payment payment = new Payment(order, request.cardNumber());

        paymentPort.pay(payment.getPrice(), payment.getCardNumber());
        paymentPort.save(payment);
    }
}

