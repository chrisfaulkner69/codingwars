package org.lucidant.kyu4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.lucidant.kyu4.HumanReadableTimeWords.SECONDS_PER_DAY;
import static org.lucidant.kyu4.HumanReadableTimeWords.SECONDS_PER_HOUR;
import static org.lucidant.kyu4.HumanReadableTimeWords.SECONDS_PER_YEAR;
import static org.lucidant.kyu4.HumanReadableTimeWords.formatDuration;
import static org.lucidant.kyu4.HumanReadableTimeWords.formatDurationAlt;

class HumanReadableTimeWordsTest {

    @Test
    void moreThanYears() {
        assertEquals("1 year", formatDuration(SECONDS_PER_YEAR));
        assertEquals("2 years", formatDuration(SECONDS_PER_YEAR * 2));
        assertEquals("1 year, 1 day, 1 hour and 1 second", formatDuration(SECONDS_PER_YEAR + SECONDS_PER_DAY + SECONDS_PER_HOUR + 1));
    }

    @Test
    void moreThanDays() {
        assertEquals("2 days, 1 hour and 1 second", formatDuration((SECONDS_PER_DAY * 2) + SECONDS_PER_HOUR + 1));
        assertEquals("1 day, 1 hour, 1 minute and 1 second", formatDuration(SECONDS_PER_DAY + SECONDS_PER_HOUR + 60 + 1));
        assertEquals("1 day, 1 hour, 1 minute and 1 second", formatDurationAlt(SECONDS_PER_DAY + SECONDS_PER_HOUR + 60 + 1));
    }

    @Test
    void moreThanHours() {
        assertEquals("1 hour", formatDuration(SECONDS_PER_HOUR));
        assertEquals("1 hour, 1 minute and 2 seconds", formatDuration(3662));
    }

    @Test
    void moreThanMinutes() {
        assertEquals("2 minutes and 2 seconds", formatDuration(122));
        assertEquals("1 minute and 2 seconds", HumanReadableTimeWords.formatDuration(62));
        assertEquals("2 minutes", HumanReadableTimeWords.formatDuration(120));
    }

    @Test
    void seconds() {
        assertEquals("59 seconds", formatDuration(59));
        assertEquals("1 second", formatDuration(1));
    }
}