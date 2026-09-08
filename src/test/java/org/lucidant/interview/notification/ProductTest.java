package org.lucidant.interview.notification;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void givenNullNameInConstructor_whenConstructed_thenExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null,0));
    }

    @Test
    void givenBlankNameInConstructor_whenConstructed_thenExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, () -> new Product(null,0));
    }

}
