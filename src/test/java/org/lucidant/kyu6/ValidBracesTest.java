/**
 *
 */
package org.lucidant.kyu6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author chrisfaulkner
 *
 */
class ValidBracesTest {

	@Test
	void testIsValid() {
		assertTrue(ValidBraces.isValid("()"));
		assertTrue(ValidBraces.isValid("(())()"));
		assertFalse(ValidBraces.isValid("(()))("));
		assertTrue(ValidBraces.isValid("([])"));
	}

}
