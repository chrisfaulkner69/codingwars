package org.lucidant.kyu5;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.codewars.com/kata/52685f7382004e774f0001f7/java">Web Link</a>
 */
class HumanReadableTime {

    private static final int SECONDS_PER_HOUR = 60 * 60;
    public static String makeReadable(int n) {


        var values = List.of("1", "A", 3, true, 5.5);
        System.out.println(values.stream().map(v ->v instanceof Number).toList());

        int[] myValues = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(myValues));


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
