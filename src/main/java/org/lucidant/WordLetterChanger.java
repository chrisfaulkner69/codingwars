package org.lucidant;

import java.util.Objects;

/**
 * Word letter changer. At most one position can be changed.
 * 
 * nice, niece should return "INSERT e"
 * niece, nice should return "DELETE e"
 * lad, lid should return "SWAP a i"
 * zebra, horse should return IMPOSSIBLE
 * zebra, zebra should return NOTHING
 * 
 * 
 * @author chrisfaulkner
 *
 */
public class WordLetterChanger {

	String solution(final String S, final String T) {
		
		// Test assumes that strings are already lowercased but we'll do this 
		final String fromString = S == null ? "" : S.toLowerCase();
		final String toString = T == null ? "" : T.toLowerCase();
		
		if (Objects.equals(fromString, toString))
		{
			return OpCode.NOTHING.name();
		}
		
		final int fromLength = fromString.length();
		final int toLength = toString.length();
		
		final int lengthDiff = fromLength - toLength;
		final String[] fromArray = fromString.split("");
		final String[] toArray = toString.split("");

		// If the difference in length is more than one or it's zero but differs in more than one position
		if (Math.abs(lengthDiff) > 1 || (Math.abs(lengthDiff) == 0 && positionsDifferentExceeded(fromArray, toArray, 1)))
		{	
			return OpCode.IMPOSSIBLE.name();
		}
		
		/// This is an INSERT
		final StringBuilder commandBuffer = new StringBuilder(8);
		if (lengthDiff < 0)
		{
			commandBuffer.append(OpCode.INSERT.name()).append(' ');
			commandBuffer.append(getCharacter(toArray, fromArray, false));
		}
		else
		{
			final OpCode opCode = lengthDiff == 0 ? OpCode.SWAP : OpCode.DELETE;
			commandBuffer.append(opCode.name()).append(' ');
			commandBuffer.append(getCharacter(fromArray, toArray, opCode == OpCode.SWAP));
		}

		return commandBuffer.toString();
	}

	private String getCharacter(final String[] fromArray, final String[] toArray, boolean swap) {
		StringBuilder command = new StringBuilder(3);
		for (int i = 0; i < fromArray.length; i++) {
			String fromLetter = fromArray[i];
			// In case the fromArray is larger than the toArray
			String toLetter = i < toArray.length ? toArray[i] : "";
			if (!fromLetter.equals(toLetter))
			{
				if (swap)
				{
					command.append(fromLetter).append(' ').append(toLetter);
				}
				else 
				{
					command.append(fromLetter);
				}
				break;
			}
		}
		return command.toString();
	}

	/**
	 * @param fromLetters
	 * @param toLetters
	 * @param max
	 * @return
	 */
	private boolean positionsDifferentExceeded(String[] fromLetters, String[] toLetters, int max) {
		int countFail = 0;
		for (int i = 0; i < fromLetters.length; i++) {
			String fromString = fromLetters[i];
			String toString = toLetters[i];
			if (!fromString.equals(toString))
			{
				countFail++;
				if (countFail > max)
				{
					return true;
				}
			}
		}
		return false;
	}

}

enum OpCode 
{
	INSERT, 
	DELETE,
	SWAP,
	NOTHING,
	IMPOSSIBLE
}
