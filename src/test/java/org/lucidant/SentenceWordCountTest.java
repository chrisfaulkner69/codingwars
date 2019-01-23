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
class SentenceWordCountTest {

	private SentenceWordCount solution;
	/**
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		solution = new SentenceWordCount();
	}

	@Test
	void test() {
		assertEquals(0, solution.solution(".!?"));
		assertEquals(0, solution.solution("."));
		assertEquals(0, solution.solution(" "));
		assertEquals(0, solution.solution(null));
		assertEquals(4, solution.solution("..I.Hello Mr No De?strange poistion limiters"));
		assertEquals(4, solution.solution("Hello Mr No De?strange poistion limiters"));
		assertEquals(1, solution.solution("Test."));
		assertEquals(1, solution.solution(".Test. I ! You ? He . She .It.They."));
		assertEquals(10, solution.solution("This is not a test ! But we do test coders. Give us a try? You will love us greatly and will want to return !"));
		assertEquals(5, solution.solution("This is not a test ! But we do test coders.    "));
		assertEquals(2, solution.solution("Forget CVs.. Sabve time. x x"));
		assertEquals(3, solution.solution("Spaces    only    spacesonly"));
		assertEquals(3, solution.solution("?Hello?Mr No De?strange?poistion limiters"));
		assertEquals(4, solution.solution("?Hello	?Mr No		No	\\.     De?stran\\.ge?poistion limiters"));
		assertEquals(5, solution.solution("    This is not a test ! But we do test coders.    "));
	}

}
