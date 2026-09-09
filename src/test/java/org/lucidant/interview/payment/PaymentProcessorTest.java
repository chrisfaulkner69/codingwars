package org.lucidant.interview.payment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PaymentProcessorTest {

    @Mock
    private PaymentStrategy paymentStrategy;

    @Test
    void givenAmount_whenProcessPayment_thenDelegatesToStrategyAndReturnsResult() {
        var amount = new BigDecimal("50.00");
        var expectedResult = new PaymentResult(true, "CreditCard");
        when(paymentStrategy.pay(amount)).thenReturn(expectedResult);

        var paymentProcessor = new PaymentProcessor(paymentStrategy);
        var actualResult = paymentProcessor.processPayment(amount);

        assertEquals(expectedResult, actualResult);
        verify(paymentStrategy).pay(amount);
    }
}
