/**
 * 
 */
package org.lucidant;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author chrisfaulkner
 *
 */
public class InterestBounds {
	
	private final BigDecimal rate;
	private final BigDecimal upperBound;
	private final BigDecimal lowerBound;
	
	public InterestBounds(BigDecimal rate, BigDecimal lowerBound, BigDecimal upperBound) {
		super();
		this.rate = rate;
		this.upperBound = upperBound;
		this.lowerBound = lowerBound;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public boolean inRange(final BigDecimal amount) {
		return amount.compareTo(upperBound) < 0 && amount.compareTo(lowerBound) >= 0;
	}
	public BigDecimal getUpperBound() {
		return upperBound;
	}
	
	public BigDecimal calculate(final BigDecimal amount) {
		return amount.multiply(rate).setScale(2, RoundingMode.HALF_UP);
	}

}
