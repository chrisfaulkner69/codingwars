package org.lucidant.interview.payment;

import java.math.BigDecimal;

public class PaymentProcessor {

    private final PaymentStrategy paymentStrategy;

    public PaymentProcessor(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public PaymentResult processPayment(BigDecimal amount) {
        return paymentStrategy.pay(amount);
    }
}
