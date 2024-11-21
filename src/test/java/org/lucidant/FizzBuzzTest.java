package org.lucidant;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author chrisfaulkner
 *
 */
public class FizzBuzzTest extends FizzBuzz {

    @DisplayName("Example Service should work!")
	@Test
	public void test() {
		new FizzBuzz().doFizzBuzz(3, 15);
	}

}
