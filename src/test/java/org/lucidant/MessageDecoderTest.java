package org.lucidant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageDecoderTest {

    @Test
    void decode() {
        final var test = MessageDecoder.decode("src/main/resources/messages.txt");
        System.out.println(test);
    }
}
