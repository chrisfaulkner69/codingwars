package org.lucidant.kyu6;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MexicanWaveTest {

    @Test
    void waveHello() {
        final var wave = MexicanWave.wave("hello");

        assertThat(wave).containsExactly("Hello", "hEllo", "heLlo", "helLo", "hellO");
    }

    @Test
    void waveSpecial() {
        final var wave = MexicanWave.wave("a$43sty");

        assertThat(wave).containsExactly("A$43sty", "a$43Sty", "a$43sTy", "a$43stY");
    }

    @Test
    void waveSingle() {
        final var wave = MexicanWave.wave("z");

        assertThat(wave).containsExactly("Z");
    }
}
