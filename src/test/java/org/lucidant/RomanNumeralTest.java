/**
 *
 */
package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class RomanNumeralTest {

	@Test
	void testOneThousand() {
		assertEquals(1000, RomanNumeral.decode("M"));
	}

	@Test
	void testTwoThousandOneHundred() {
		assertEquals(2100, RomanNumeral.decode("MMC"));
	}

	@Test
	void testOneThousandNineHundred() {
		assertEquals(1900, RomanNumeral.decode("MCM"));
	}

	@Test
	void test1983() {
		assertEquals(1983, RomanNumeral.decode("MCMLXXXIII"));
	}

	@Test
	void test1999() {
		assertEquals(1999, RomanNumeral.decode("MCMXCIX"));
	}

	@Test
	void test1666() {
		assertEquals(1666, RomanNumeral.decode("MDCLXVI"));
	}

	@Test
	void test1901() {
		assertEquals(1901, RomanNumeral.decode("MCMI"));
	}


	@DisplayName("Roman numeral")
	@ParameterizedTest(name = "\"{0}\" should be {1}")
	@CsvSource({ "I, 1", "II, 2", "IV, 4", "V, 5", "MCM, 1900", "MMMCMXCIX, 3999"})
	void testToRoman(String expected, int input) {
		assertEquals(expected, RomanNumeral.toRoman(input));
	}
}
