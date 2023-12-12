import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.lucidant.RegexValidator.SIMPLE_PWD;
import static org.lucidant.RegexValidator.validatePin;

class RegexValidatorTest {


    @Test
    void simplePasswordRegex() {
        // OK
        assertThat(SIMPLE_PWD.matcher("1aD1AD").matches()).isTrue();
        assertThat(SIMPLE_PWD.matcher("Zz1234").matches()).isTrue();
        assertThat(SIMPLE_PWD.matcher("Zz1234Zz1234Zz1234Zz1234Zz1234Zz1234Zz1234Zz1234").matches()).isTrue();

        // Invalid
        assertThat(SIMPLE_PWD.matcher("1D1ad").matches()).isFalse();
        assertThat(SIMPLE_PWD.matcher("1aaa2a").matches()).isFalse();
        assertThat(SIMPLE_PWD.matcher("{1D1AD").matches()).isFalse();
    }


    @Nested
    class PinRegex {
        @Test
        void validPins() {
            assertTrue(validatePin("1234"));
            assertTrue(validatePin("0000"));
            assertTrue(validatePin("1111"));
            assertTrue(validatePin("123456"));
            assertTrue(validatePin("098765"));
            assertTrue(validatePin("000000"));
            assertTrue(validatePin("090909"));
        }

        @Test
        void nonDigitCharacters() {
            assertFalse(validatePin("a234"));
            assertFalse(validatePin(".234"));
        }

        @Test
        void invalidLengths() {
            assertFalse(validatePin("1"));
            assertFalse(validatePin("12"));
            assertFalse(validatePin("123"));
            assertFalse(validatePin("12345"));
            assertFalse(validatePin("1234567"));
            assertFalse(validatePin("-1234"));
            assertFalse(validatePin("1.234"));
            assertFalse(validatePin("00000000"));
        }
    }
}
