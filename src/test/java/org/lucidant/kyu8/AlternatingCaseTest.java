package org.lucidant.kyu8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AlternatingCaseTest {

	private AlternatingCase alternatingCase;

	@BeforeEach
	void setUp() {
		alternatingCase = new AlternatingCase();
	}

	@Test
	void test() {
	 	assertEquals("A", new AlternatingCase().toAlternativeString("a"));

	 	assertEquals("HELLO WORLD", alternatingCase.toAlternativeString("hello world"));
	 	assertEquals("HELLO WORLD", alternatingCase.toAlternativeString("hello world"));
	 	assertEquals("/Z1234A{}", alternatingCase.toAlternativeString("/z1234a{}"));
	 	assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", alternatingCase.toAlternativeString("StringUtils.toAlternatingCase"));
	}

}
