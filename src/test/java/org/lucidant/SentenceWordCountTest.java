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

	private SentenceWordCount sentenceWordCount;

	@BeforeEach
	void setUp() {
		sentenceWordCount = new SentenceWordCount();
	}

	@Test
	void test() {
		assertEquals(0, sentenceWordCount.solution(".!?"));
		assertEquals(0, sentenceWordCount.solution("."));
		assertEquals(0, sentenceWordCount.solution(" "));
		assertEquals(0, sentenceWordCount.solution(null));
		assertEquals(4, sentenceWordCount.solution("..I.Hello Mr No De?strange position limiters"));
		assertEquals(4, sentenceWordCount.solution("Hello Mr No De?strange position limiters"));
		assertEquals(1, sentenceWordCount.solution("Test."));
		assertEquals(1, sentenceWordCount.solution(".Test. I ! You ? He . She .It.They."));
		assertEquals(10, sentenceWordCount.solution("This is not a test ! But we do test coders. Give us a try? You will love us greatly and will want to return !"));
		assertEquals(5, sentenceWordCount.solution("This is not a test ! But we do test coders.    "));
		assertEquals(2, sentenceWordCount.solution("Forget CVs.. Save time. x x"));
		assertEquals(3, sentenceWordCount.solution("Spaces    only    spacesonly"));
		assertEquals(3, sentenceWordCount.solution("?Hello?Mr No De?strange?poistion limiters"));
		assertEquals(4, sentenceWordCount.solution("?Hello	?Mr No		No	\\.     De?stran\\.ge?poistion limiters"));
		assertEquals(5, sentenceWordCount.solution("    This is not a test ! But we do test coders.    "));
	}

}
