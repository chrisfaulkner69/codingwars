package org.lucidant.kyu7;

import java.util.Locale;
import java.util.stream.Collectors;

public class IsogramNew {

    public static boolean isIsogram(final String str) {
        if (str == null || str.trim().isEmpty()) {
            return true;
        }
        // Get the string with no non-alphabetical characters
        final var alphabetOnly = str.toLowerCase(Locale.ROOT).chars()
                .filter(Character::isLetter)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());

        return alphabetOnly.length() == alphabetOnly.chars().distinct().count();
    }
}
