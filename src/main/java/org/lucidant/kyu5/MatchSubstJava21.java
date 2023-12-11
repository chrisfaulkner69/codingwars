package org.lucidant.kyu5;

import static org.lucidant.kyu5.MatchSubst.DECIMAL_PATTERN;
import static org.lucidant.kyu5.MatchSubst.ERROR;
import static org.lucidant.kyu5.MatchSubst.PHONE_PATTERN;
import static org.lucidant.kyu5.MatchSubst.getInputValueFor;

public class MatchSubstJava21 {

    public static String change(String baseStr, String prog, String version) {
        if (baseStr == null || baseStr.length() < 50) {
            return ERROR;
        }

        final var inputPhone = getInputValueFor("Phone:", baseStr);
        final var inputVersion = getInputValueFor("Version:", baseStr);
        if (!PHONE_PATTERN.matcher(inputPhone.trim()).matches() || !DECIMAL_PATTERN.matcher(inputVersion.trim()).matches()) {
            return ERROR;
        }

        final var substVersion = !inputVersion.equals("2.0") ? version : "2.0";
        return STR."Program: \{prog} Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: \{substVersion}";
    }

}
