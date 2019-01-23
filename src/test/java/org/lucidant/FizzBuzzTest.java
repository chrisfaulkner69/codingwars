package org.lucidant;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void tests() {
      assertEquals("67", FizzBuzz.numberToString(67));
      assertEquals("123", FizzBuzz.numberToString(123));
      assertEquals("999", FizzBuzz.numberToString(999));
    }
}
