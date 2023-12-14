package org.lucidant.kyu5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PigLatinTest {

    @Test
    void sampleTests() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigIt("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigIt("This is my string"));

        assertEquals("Oay emporatay oay oresmay !", PigLatin.pigIt("O tempora o mores !"));
    }

    @Test
    void sampleTests2() {
        assertEquals("igPay atinlay siay oolcay", PigLatin.pigItFromWeb("Pig latin is cool"));
        assertEquals("hisTay siay ymay tringsay", PigLatin.pigItFromWeb("This is my string"));

        assertEquals("Oay emporatay oay oresmay !", PigLatin.pigItFromWeb("O tempora o mores !"));
    }

}
