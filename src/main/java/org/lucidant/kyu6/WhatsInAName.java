package org.lucidant.kyu6;

import java.util.List;

/**
 * String intersection.
 * https://www.codewars.com/kata/59daf400beec9780a9000045
 */
public class WhatsInAName {

    public static boolean nameInStr(final String source, final String name){
        if (source == null || name == null) {
            return false;
        }
        var base = source.trim().toLowerCase();
        final var compare = name.trim().toLowerCase();

        final List<Character> chars = compare.chars()
                .mapToObj(e->(char)e)
                .toList();
        for (final char c : chars) {
            final int position = base.indexOf(c);
            if (position >= 0) {
                base = base.substring(position+1);
            }
            else {
                return false;
            }
        }

        return true;
    }

}
