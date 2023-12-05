/**
 * 
 */
package org.lucidant;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author chrisfaulkner
 *
 */
class CenturyFromYearTest {

	@Test
	void testCentury() {
        assertEquals(18, CenturyFromYear.century(1705));
        assertEquals(19, CenturyFromYear.century(1900));
        assertEquals(17, CenturyFromYear.century(1601));
        assertEquals(20, CenturyFromYear.century(2000));
        assertEquals(1,  CenturyFromYear.century(89));
        assertEquals(17, CenturyFromYear.century(1699));
        assertEquals(7, CenturyFromYear.century(699));
        assertEquals(25, CenturyFromYear.century(25000));
	}

}
