package io.github.vicen621;

import io.github.vicen621.datelapse.DateLapseDates;
import io.github.vicen621.datelapse.DateLapseDays;
import io.github.vicen621.datelapse.DateRangeable;
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

    @Test
    void testDateLapseDatesOverlap() {
        DateLapseDates period1 = new DateLapseDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
        DateLapseDates period2 = new DateLapseDates(LocalDate.of(2023, 1, 5), LocalDate.of(2023, 1, 15));

        assertTrue(period1.overlaps(period2));
        assertTrue(period2.overlaps(period1));
    }

    @Test
    void testDateLapseDatesNoOverlap() {
        DateLapseDates period1 = new DateLapseDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
        DateLapseDates period2 = new DateLapseDates(LocalDate.of(2023, 1, 11), LocalDate.of(2023, 1, 20));

        assertFalse(period1.overlaps(period2));
        assertFalse(period2.overlaps(period1));
    }

    @Test
    void testDateLapseDaysOverlap() {
        DateLapseDays period1 = new DateLapseDays(LocalDate.of(2023, 1, 1), 10); // 1-10 Jan 2023
        DateLapseDays period2 = new DateLapseDays(LocalDate.of(2023, 1, 5), 10); // 5-14 Jan 2023

        assertTrue(period1.overlaps(period2));
        assertTrue(period2.overlaps(period1));
    }

    @Test
    void testDateLapseDaysNoOverlap() {
        DateLapseDays period1 = new DateLapseDays(LocalDate.of(2023, 1, 1), 10); // 1-10 Jan 2023
        DateLapseDays period2 = new DateLapseDays(LocalDate.of(2023, 1, 15), 5); // 15-19 Jan 2023

        assertFalse(period1.overlaps(period2));
        assertFalse(period2.overlaps(period1));
    }

    @Test
    void testDateLapseDatesAndDaysOverlap() {
        DateLapseDates period1 = new DateLapseDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 10));
        DateLapseDays period2 = new DateLapseDays(LocalDate.of(2023, 1, 5), 5); // 5-9 Jan 2023

        assertTrue(period1.overlaps(period2));
        assertTrue(period2.overlaps(period1));
    }

    @Test
    void testDateLapseDatesAndDaysNoOverlap() {
        DateLapseDates period1 = new DateLapseDates(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 1, 5));
        DateLapseDays period2 = new DateLapseDays(LocalDate.of(2023, 1, 6), 5); // 6-10 Jan 2023

        assertFalse(period1.overlaps(period2));
        assertFalse(period2.overlaps(period1));
    }
}
