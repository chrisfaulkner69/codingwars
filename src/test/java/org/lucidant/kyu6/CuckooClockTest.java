package org.lucidant.kyu6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.lucidant.kyu6.CuckooClock.cuckooClock;

class CuckooClockTest {
    @Test
    void simpleTests()  {
//        assertThat(cuckooClock("07:22", 1)).isEqualTo("07:30");

        // 3:45 = 1
        // 4:00 = 4 (5)
        // 4:15 = 1 (6)
        // 4:30 = 1 (8)
        // 4:45 = 1 (9)
        // 5:00 = 5 (14)
        // 5:15 = 1 (15)
        // 5:30 = 1 (16)
        // 5:45 = 1 (17)
        // 6:00 = 6 (23)
        assertThat(cuckooClock("03:38", 19)).isEqualTo("06:00");
        final List<String> initialTimes = Arrays.asList("07:22", "12:22", "01:30", "04:01", "03:38");
        final List<Integer> chimes = Arrays.asList(1, 2, 2, 10, 19);
        final List<String> expectedTimes = Arrays.asList("07:30", "12:45", "01:45", "05:30", "06:00");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

    @Test
    void hourTests()  { // Test case where the starting time is 00, i.e. on the hour
        final List<String> initialTimes = Arrays.asList("10:00", "10:00", "10:00", "10:00", "10:00");
        final List<Integer> chimes = Arrays.asList(1, 10, 11, 13, 20);
        final List<String> expectedTimes = Arrays.asList("10:00", "10:00", "10:15", "10:45", "11:00");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

    @Test
    void twelveTests()  { // Test going from twelve to one
        final List<String> initialTimes = Arrays.asList("12:30", "12:30", "12:30", "12:30", "09:53");
        final List<Integer> chimes = Arrays.asList(1, 2, 3, 4, 50);
        final List<String> expectedTimes = Arrays.asList("12:30", "12:45", "01:00", "01:15", "02:30");

        for (int i = 4; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

    @Test
    void aroundTheClockTests()  { // Test going more than 12 hours ahead
        final List<String> initialTimes = Arrays.asList("08:17", "08:17", "08:17", "08:17", "08:17");
        final List<Integer> chimes = Arrays.asList(113, 114, 115, 150, 200);
        final List<String> expectedTimes = Arrays.asList("08:00", "08:15", "08:30", "11:00", "05:45");

        for (int i = 0; i < initialTimes.size(); i++) {
            assertEquals(expectedTimes.get(i), cuckooClock(initialTimes.get(i), chimes.get(i)));
        }
    }

}
