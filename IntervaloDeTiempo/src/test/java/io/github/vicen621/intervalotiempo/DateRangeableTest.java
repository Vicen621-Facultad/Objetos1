package io.github.vicen621.intervalotiempo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DateRangeableTest {
    private DateRangeable dateLapseDates;
    private DateRangeable dateLapseDays;

    @BeforeEach
    public void setup() {
        dateLapseDates = new DateLapseDates(
                LocalDate.of(2024, 9, 1),
                LocalDate.of(2024, 9, 30)
        );
        dateLapseDays = new DateLapseDays(
            LocalDate.of(2024, 9, 1),
                29
        );
    }

    @Test
    public void test_size_in_days() {
        assertEquals(dateLapseDates.sizeInDays(), 29);
        assertEquals(dateLapseDays.sizeInDays(), 29);
    }

    @Test
    public void test_includes_date() {
        LocalDate between = LocalDate.of(2024, 9, 15);
        LocalDate after = LocalDate.of(2024, 10, 1);
        LocalDate before = LocalDate.of(2024, 8, 31);

        assertTrue(dateLapseDates.includesDate(between));
        assertTrue(dateLapseDays.includesDate(between));
        assertFalse(dateLapseDates.includesDate(after));
        assertFalse(dateLapseDays.includesDate(after));
        assertFalse(dateLapseDates.includesDate(before));
        assertFalse(dateLapseDays.includesDate(before));
    }
}
