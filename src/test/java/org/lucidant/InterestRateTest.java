/**
 * 
 */
package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class InterestRateTest {

	private InterestRate interestRate;
	
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		final InterestBounds bound1 = new InterestBounds(new BigDecimal("0.01"), new BigDecimal("0.00"), new BigDecimal("1000.00"));
		final InterestBounds bound2 = new InterestBounds(new BigDecimal("0.02"), new BigDecimal("1000.00"), new BigDecimal("5000.00"));
		final InterestBounds bound3 = new InterestBounds(new BigDecimal("0.03"), new BigDecimal("5000.00"), new BigDecimal("10000000.00"));
		interestRate = new InterestRate(Arrays.asList(bound1, bound2, bound3));
	}

	@Test
	void testMinRange() {
		assertEquals(new BigDecimal("0.00"), interestRate.calculate(new BigDecimal("0.00")));
		assertEquals(new BigDecimal("0.00"), interestRate.calculate(new BigDecimal("-1.00")));
		assertEquals(new BigDecimal("5.00"), interestRate.calculate(new BigDecimal("500.00")));
		assertEquals(new BigDecimal("5.00"), interestRate.calculate(new BigDecimal("500.49")));
		assertEquals(new BigDecimal("5.01"), interestRate.calculate(new BigDecimal("500.50")));
		assertEquals(new BigDecimal("10.00"), interestRate.calculate(new BigDecimal("999.99")));
	}

	
	@Test
	void testMidRange() {
		assertEquals(new BigDecimal("20.00"), interestRate.calculate(new BigDecimal("1000.00")));
		assertEquals(new BigDecimal("100.00"), interestRate.calculate(new BigDecimal("4999.99")));
	}

	@Test
	void testMaxRange() {
		assertEquals(new BigDecimal("150.00"), interestRate.calculate(new BigDecimal("5000.00")));
		assertEquals(new BigDecimal("300.00"), interestRate.calculate(new BigDecimal("10000.00")));
	}

}
