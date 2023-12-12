package org.lucidant.kyu4;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class HumanReadableTimeWords {
    public static final int SECONDS_PER_HOUR = 60 * 60;
    public static final int SECONDS_PER_DAY = 86_400;

    public static final int SECONDS_PER_YEAR = 31_536_000;

    public static String formatDuration(int secs) {

        final List<String> times = new ArrayList<>(6);
        final int years = secs / SECONDS_PER_YEAR;
        addTime(times, "year", years);
        secs %= SECONDS_PER_YEAR;
        final int days = secs / SECONDS_PER_DAY;
        addTime(times, "day", days);

        final var duration = Duration.ZERO.plusSeconds(secs);
        final int hours = duration.toHoursPart();
        final int minutes = duration.toMinutesPart();
        final int seconds = duration.toSecondsPart();
        addTime(times, "hour", hours);
        addTime(times, "minute", minutes);
        addTime(times, "second", seconds);
        final int timesSize = times.size();
        // Left the comment in to show string template
        return switch (timesSize) {
            case 0 -> "now";
            case 1 -> times.getFirst();
//            default -> times.stream()
//                    .limit(timesSize - 1)
//                    .collect(Collectors.joining(", "))
//                    + " and " + times.get(timesSize - 1);
            default -> STR."\{times.stream()
                    .limit(timesSize - 1)
                    .collect(Collectors.joining(", "))} and \{times.getLast()}";
        };
    }

    private static void addTime(List<String> times, String word, int value) {
        if (value > 0) {
            times.add(String.format("%s " + word + "%s", value, (value > 1) ? "s" : ""));
        }
    }

    /**
     * I liked this because it makes the stream dynamically (at the expense of extra mathematical operations).
     * Also, the regex to just replace last character.
     */
    public static String formatDurationAlt(int seconds) {
        final var str = seconds == 0 ? "now"
                : Arrays.stream(new String[]{
                        formatTime("year", (seconds/31536000)),
                        formatTime("day", (seconds/86400)%365),
                        formatTime("hour", (seconds/3600)%24),
                        formatTime("minute", (seconds/60)%60),
                        formatTime("second", (seconds%3600)%60)})
                .filter(p -> !Objects.equals(p, ""))
                .collect(Collectors.joining(", "));

        // See https://regexr.com/7ovld for a saved regex
        return str.replaceAll(", (?!.+,)", " and ");
    }
    public static String formatTime(String word, int time){
        return time == 0 ? "" : time +" "+word+(time == 1 ? "":"s");
    }


}
