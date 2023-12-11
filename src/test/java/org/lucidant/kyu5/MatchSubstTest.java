package org.lucidant.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.lucidant.kyu5.MatchSubst.ERROR;

class MatchSubstTest {
    private static final String TEST_STR = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";

    @Test
    void invalidInput() {
        assertThat(MatchSubst.change("", "name", "2.0")).isEqualTo(ERROR);
        assertThat(MatchSubst.change(null, "name", "2.0")).isEqualTo(ERROR);
        assertThat(MatchSubstJava21.change("", "name", "2.0")).isEqualTo(ERROR);
        assertThat(MatchSubstJava21.change(null, "name", "2.0")).isEqualTo(ERROR);
    }

    @Test
    void invalidVersions() {
        assertThat(MatchSubst.change(TEST_STR.replace("Version: 6.7", "Version: .2"), "name", "2.0"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change(TEST_STR.replace("Version: 6.7", "Version 1.2.2"), "name", "2.0"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change(TEST_STR.replace("Version: 6.7", "Version 5"), "name", "5"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change(TEST_STR.replace("Version: 6.7", "Version 5"), "name", "5"))
                .isEqualTo(ERROR);
    }

    @Test
    void invalidPhoneNumber() {
        assertThat(MatchSubst.change("Program: Primes: Gold\nPhone: +1-50-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha", "name", "1.2"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change("Program: Primes: Gold\nPhone: +2-50-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha", "name", "1.2"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change("Program: Primes: Gold\nPhone: 50-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha", "name", "1.2"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change("Program: Primes: Gold\nPhone: +1-5a0-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha", "name", "1.2"))
                .isEqualTo(ERROR);
        assertThat(MatchSubst.change("Program: Primes: Gold\nPhone: +1-5000-555-0091\nDate: Tues \n", "name", "1.2"))
                .isEqualTo(ERROR);
    }

    @Test
    void test() {

        final var s1a = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0094\nDate: Tues April 9, 2005\nVersion: 1.32\nLevel: Alpha";
        assertThat(MatchSubst.change(s1a, "Circular", "0.2" )).isEqualTo("Program: Circular Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 0.2");
        assertThat(MatchSubstJava21.change(s1a, "Circular", "0.2" )).isEqualTo("Program: Circular Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 0.2");

        final var s1 = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-0091\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
        assertThat(MatchSubst.change(s1, "Ladder", "1.1" )).isEqualTo("Program: Ladder Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.1");
        assertThat(MatchSubstJava21.change(s1, "Ladder", "1.1" )).isEqualTo("Program: Ladder Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 1.1");

        final var s11 = "Program title: Hammer\nAuthor: Tolkien\nCorporation: IB\nPhone: +1-503-555-0090\nDate: Tues March 29, 2017\nVersion: 2.0\nLevel: Release";
        assertThat(MatchSubst.change(s11, "Balance", "1.5.6" )).isEqualTo("Program: Balance Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.0");
        assertThat(MatchSubstJava21.change(s11, "Balance", "1.5.6" )).isEqualTo("Program: Balance Author: g964 Phone: +1-503-555-0090 Date: 2019-01-01 Version: 2.0");

        final var s12 = "Program title: Primes\nAuthor: Kern\nCorporation: Gold\nPhone: +1-503-555-009\nDate: Tues April 9, 2005\nVersion: 6.7\nLevel: Alpha";
        assertThat(MatchSubst.change(s12, "Ladder", "1.1" )).isEqualTo(ERROR);
        assertThat(MatchSubstJava21.change(s12, "Ladder", "1.1" )).isEqualTo(ERROR);
    }

}