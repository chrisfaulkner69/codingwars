package org.lucidant.kyu6;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * <a href="https://www.codewars.com/kata/656e4602ee72af0017e37e82">Code Wars</a>
 */
public class CuckooClock {

    private static final int[] QUARTERS = {15, 30, 45};
    private CuckooClock() {
        // PMD
    }

    public static String cuckooClock(String inputTime, int chimes) {
        final String[] hoursAndMins = inputTime.split(":");
        int hours = Integer.parseInt(hoursAndMins[0]);
        int minutes = Integer.parseInt(hoursAndMins[1]);
        var time = getNextMins(hours, minutes);

        int chimeCount = 0;
        while (chimeCount <= chimes) {
            final int minute = time.getMinute();
            if (minute == 15 || minute == 45 || minute == 30) {
                chimeCount++;
            }
            else {
                chimeCount = chimeCount + (time.getHour()%12 == 0 ? 12 : time.getHour()%12);
            }
            if (chimeCount < chimes) {
                time = time.plusMinutes(15);
            }
        }

        return time.format(DateTimeFormatter.ofPattern("hh:mm"));
    }

    static LocalTime getNextMins(int hours, int mins) {
        if (mins == 0 || mins == 15 || mins == 30 || mins == 45) {
            return LocalTime.of(hours, mins);
        }
        else {
            int roundedMins = 0;
            for (int quarter : QUARTERS) {
                if (mins < quarter) {
                    roundedMins = quarter;
                    break;
                }
            }
            return LocalTime.of(roundedMins == 0 ? hours + 1 : hours, roundedMins);
        }
    }
}
