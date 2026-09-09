package org.lucidant.interview.payment;

import java.math.BigDecimal;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    @Override
    public PaymentResult pay(BigDecimal amount) {
        return new PaymentResult(true, "credit card payment successful");
    }
}
