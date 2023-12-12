package org.lucidant;

import java.util.regex.Pattern;

public class RegexValidator {

    private RegexValidator() {
        // NOOP
    }

    /**
     * <a href="https://regexr.com/7ovvk"></a>
     * One upper case letter, one lower, one digit, nothing else. Forward-looking.
     */
    public static final Pattern SIMPLE_PWD = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[A-Za-z\\d]{6,}$");

    private static final Pattern PIN_4DIGIT = Pattern.compile("^([\\d]{4}|[\\d]{6})$");

    public static boolean validatePin(String number) {
        return PIN_4DIGIT.matcher(number).matches();
    }
}
