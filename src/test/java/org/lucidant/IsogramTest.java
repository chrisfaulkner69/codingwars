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
public class IsogramTest {

	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
        assertEquals(Isogram.isIsogram("Dermatoglyphics"), true);
        assertEquals(Isogram.isIsogram("isogram") , true);
        assertEquals(Isogram.isIsogram("moose") , false);
        assertEquals(Isogram.isIsogram("isIsogram") , false);
        assertEquals(Isogram.isIsogram("aba") , false);
        assertEquals(Isogram.isIsogram("moOse") , false);
        assertEquals(Isogram.isIsogram("thumbscrewjapingly") , true);
        assertEquals(Isogram.isIsogram("") , true); 
	}

}
