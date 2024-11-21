package org.lucidant.codesignal;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class IntegerSumTest {

    @Test
    void givenErrors_returnZero() {
        assertThat(IntegerSum.solution(0)).isEqualTo(0);
    }

    @Test
    void givenNormalIntegers_returnTheSum() {
        assertThat(IntegerSum.solution(11)).isEqualTo(2);
    }

    @Test
    void givenNegativeInteger_returnTheSum() {
        assertThat(IntegerSum.solution(-222)).isEqualTo(6);
    }

}
