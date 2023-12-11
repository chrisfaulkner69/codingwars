package org.lucidant.kyu5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.lucidant.kyu5.HumanReadableTime.makeReadable;
import static org.lucidant.kyu5.HumanReadableTime.makeReadableWithDuration;

public class HumanReadableTimeTest {

    @Test
    void testLessThanMinutes() {
        assertThat(makeReadable(0)).isEqualTo("00:00:00");
        assertThat(makeReadable(59)).isEqualTo("00:00:59");

        assertThat(makeReadableWithDuration(0)).isEqualTo("00:00:00");
        assertThat(makeReadableWithDuration(59)).isEqualTo("00:00:59");
    }

    @Test
    void testLessThanHours() {
        assertThat(makeReadable(320)).isEqualTo("00:05:20");
        assertThat(makeReadable(3599)).isEqualTo("00:59:59");

        assertThat(makeReadableWithDuration(320)).isEqualTo("00:05:20");
        assertThat(makeReadableWithDuration(3599)).isEqualTo("00:59:59");
    }

    @Test
    void testMultipleHours() {
        assertThat(makeReadable(3600)).isEqualTo("01:00:00");
        assertThat(makeReadable(3661)).isEqualTo("01:01:01");

        assertThat(makeReadableWithDuration(3600)).isEqualTo("01:00:00");
        assertThat(makeReadableWithDuration(3661)).isEqualTo("01:01:01");
    }

    @Test
    void testMoreThan24Hours() {
        assertThat(makeReadable(356400)).isEqualTo("99:00:00");
        assertThat(makeReadable(356405)).isEqualTo("99:00:05");
        assertThat(makeReadable(359999)).isEqualTo("99:59:59");

        assertThat(makeReadableWithDuration(356400)).isEqualTo("99:00:00");
        assertThat(makeReadableWithDuration(356405)).isEqualTo("99:00:05");
        assertThat(makeReadableWithDuration(359999)).isEqualTo("99:59:59");
    }
}
