/**
 *
 */
package org.lucidant;

import java.util.*;

/**
 * @author chrisfaulkner
 *
 */
public class ValidBraces {

	private static Map<Character, Character> BRACKET_COMBOS = new HashMap<Character, Character>(3);

	private static final Set<Character> OPENERS = new HashSet<>(3);
	private static final Set<Character> CLOSERS = new HashSet<>(3);

	static
	{
		BRACKET_COMBOS.put('(', ')');
		BRACKET_COMBOS.put('{', '}');
		BRACKET_COMBOS.put('[', ']');

		OPENERS.addAll(BRACKET_COMBOS.keySet());
		CLOSERS.addAll(BRACKET_COMBOS.values());
	}

	/**
	 * Implementation uses a stack to keep an ordered collection of opening braces. Opening ones are added and as the closing are found
	 * then the opening are removed from the stack.
	 *
	 *  For "()", first iteration puts the ( on the stack second goes to the else, finds that there is a ( on the  top of the stack and removes it.
	 *  All clear.
	 *
	 *  <p>For ([]), it's the same really, we get ( on stack, then [ so [ is at top. If the next character is ] then all good and stack is popped.
	 *  If the next character had been ), it would not have been the correct and we'd leave the loop.
	 *
	 * @param braces
	 * @return
	 */
	public static boolean isValid(final String braces)
	{
		// The stack only ever contains opening braces
		final Stack<Character> openBraces = new Stack<Character>();

		for (int i = 0; i < braces.length(); i++)
		{
			final char currentBrace = braces.charAt(i);

			// Current one is an open braces
			if (OPENERS.contains(currentBrace))
			{
				openBraces.push(currentBrace);
			}
			else if (CLOSERS.contains(currentBrace))
			{
				// Closes correct type
				if (!openBraces.empty() && closesOpenedBracket(currentBrace, openBraces.peek()))
				{
					openBraces.pop();
				}
				else
				{
					// We've got a closing brace but noting which opened it on the stack
					// Favour single exit point
					openBraces.push('.');
					break;
				}
			}
		}

		return openBraces.empty();
	}

	/**
	 * Dos the current braces match the entry at the top of the stack ?
	 * @param currentBrace
	 * @param lastOpener
	 * @return
	 */
	private static boolean closesOpenedBracket(final char currentBrace, final char lastOpener)
	{
		return BRACKET_COMBOS.get(lastOpener) == currentBrace;
	}

}
