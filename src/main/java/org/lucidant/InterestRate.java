/**
 * 
 */
package org.lucidant;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author chrisfaulkner
 *
 */
public class InterestRate {

	private static final BigDecimal LESS_THOUSAND_RATE = new BigDecimal("0.01");
	private static final BigDecimal MORE_THOUSAND_RATE = new BigDecimal("0.02");
	private static final BigDecimal MORE_FIVE_THOUSAND_RATE = new BigDecimal("0.03");
	
	private List<InterestBounds> interestBounds;
	
	public InterestRate(List<InterestBounds> interestBounds) {
		this.interestBounds = interestBounds;
	}
	
	public BigDecimal calculate(BigDecimal amount) {

		return interestBounds.stream()
				.filter(bound -> bound.inRange(amount))
				.findFirst()
				.map(bound -> bound.calculate(amount))
				.orElse(BigDecimal.ZERO.setScale(2));
	}

}
