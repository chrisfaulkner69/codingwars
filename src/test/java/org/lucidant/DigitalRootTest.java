/**
 * 
 */
package org.lucidant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class DigitalRootTest {

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		assertEquals(7, DigitalRoot.digitalRoot(16));
		assertEquals(6, DigitalRoot.digitalRoot(942));
		assertEquals(6, DigitalRoot.digitalRoot(132189));
		assertEquals(2, DigitalRoot.digitalRoot(493193));
		assertEquals(9, DigitalRoot.digitalRoot(9));
		assertEquals(6, DigitalRoot.digitalRoot(-942));
		assertEquals(0, DigitalRoot.digitalRoot(0));
		assertEquals(1, DigitalRoot.digitalRoot(10));
		assertEquals(1, DigitalRoot.digitalRoot(199));
	}

}
