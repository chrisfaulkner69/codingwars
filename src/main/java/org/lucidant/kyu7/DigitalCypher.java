package org.lucidant.kyu7;

/**
 * Primitive cypher.
 * @see <a href="https://www.codewars.com/kata/592e830e043b99888600002d/train/java">Source</a>
 *
 */
public final class DigitalCypher {
    private DigitalCypher() {

    }
    public static final int OFFSET = 96;
    public static int[] encode(final String message, final int key) {
        int count = 0;
        int lengthCount = 0;
        final var keyStr = String.valueOf(key);
        final int keyLength = keyStr.length();
        final var retVal = new int[message.length()];

        for (final char c : message.toCharArray()) {
            final var val = keyStr.substring(lengthCount, lengthCount+1);
            retVal[count] = (c - OFFSET) + Integer.parseInt(val);
            count++;
            lengthCount++;
            if (lengthCount >= keyLength) {
                lengthCount = 0;
            }
        }
        return retVal;
    }
}
