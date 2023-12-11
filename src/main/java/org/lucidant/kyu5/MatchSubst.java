package org.lucidant.kyu5;

import java.util.regex.Pattern;

public class MatchSubst {

    public static final Pattern DECIMAL_PATTERN = Pattern.compile("[0-9]{1,}\\.[0-9]{1,}$");
    public static final Pattern PHONE_PATTERN = Pattern.compile("\\+1-[0-9]{3}-[0-9]{3}-[0-9]{4}$");
    public static final String ERROR = "ERROR: VERSION or PHONE";
    public static final String LINE_SEP = System.lineSeparator();

    public static String change(String baseStr, String prog, String version) {

        if (baseStr == null || baseStr.length() < 50) {
            return ERROR;
        }

        final var inputVersion = getInputValueFor("Version:", baseStr);
        final var inputPhone = getInputValueFor("Phone:", baseStr);
        if (!PHONE_PATTERN.matcher(inputPhone.trim()).matches() || !DECIMAL_PATTERN.matcher(inputVersion.trim()).matches()) {
            return ERROR;
        }

        return String.format("Program: %s Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: %s", prog, !inputVersion.equals("2.0") ? version : "2.0");
    }

    static String getInputValueFor(String s, String baseStr) {
        final int startPos = baseStr.indexOf(s) + s.length();
        return baseStr.substring(startPos, baseStr.indexOf(LINE_SEP, startPos)).trim();
    }

}
