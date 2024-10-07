package io.github.vicen621.intervalotiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseDates implements DateRangeable {
    private LocalDate from;
    private LocalDate to;

    public DateLapseDates(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public int sizeInDays() {
        return (int) from.until(to, ChronoUnit.DAYS);
    }

    public boolean includesDate(LocalDate other) {
        return other.isAfter(from) && other.isBefore(to);
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
}
