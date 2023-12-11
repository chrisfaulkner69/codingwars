package org.lucidant.kyu5;

import java.time.Duration;

/**
 * <a href="https://www.codewars.com/kata/52685f7382004e774f0001f7/java">Web Link</a>
 */
class HumanReadableTime {

    private static final int SECONDS_PER_HOUR = 60 * 60;
    public static String makeReadable(int n) {

        int hours = n / SECONDS_PER_HOUR;
        n %= SECONDS_PER_HOUR;
        int minutes = n / 60;
        n %= 60;
        return String.format("%02d:%02d:%02d", hours, minutes, n);
    }

    /**
     * Disappointingly, disregarded some of the Java language built ins when starting this problem !
     */
    public static String makeReadableWithDuration(final int seconds) {

        final var duration = Duration.ZERO.plusSeconds(seconds);
        return String.format("%02d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart());
    }
}
