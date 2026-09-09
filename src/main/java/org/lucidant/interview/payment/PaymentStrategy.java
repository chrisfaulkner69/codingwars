package org.lucidant.interview.payment;

import java.math.BigDecimal;

public interface PaymentStrategy {

    PaymentResult pay(BigDecimal amount);
}
