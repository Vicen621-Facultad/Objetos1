package io.github.vicen621.intervalotiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseDays implements DateRangeable {

    private LocalDate from;
    private int sizeInDays;

    public DateLapseDays(LocalDate from, int sizeInDays) {
        this.from = from;
        this.sizeInDays = sizeInDays;
    }

    @Override
    public int sizeInDays() {
        return sizeInDays;
    }

    @Override
    public boolean includesDate(LocalDate other) {
        return other.isAfter(from) && other.isBefore(from.plusDays(sizeInDays));
    }
}
